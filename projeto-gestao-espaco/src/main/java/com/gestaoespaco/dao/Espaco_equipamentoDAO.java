package com.gestaoespaco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gestaoespaco.model.Espaco_equipamento;

public class Espaco_equipamentoDAO {
	private Connection conexao = null;

	public Espaco_equipamentoDAO() {
		conexao = BancoConexaoDAO.getConexao();
	}

	public void addEspEq(Espaco_equipamento espEq) {
		String sql = "INSERT INTO espaco_equipamento (id_espaco, id_equipamento, quantidade) VALUES (?, ?, ?)";
		// query para adicionar o espaço
		conexao = BancoConexaoDAO.getConexao();

		try {
			// o preparedStatement é para preparar a query, substituindo os valores dos ?
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, espEq.getId_espaco());
			stmt.setInt(2, espEq.getId_equipamento());
			stmt.setInt(2, espEq.getQuantidade());
			stmt.executeUpdate();
			stmt.close();
			System.out.println("Histórico de reserva adicionado com sucesso:");
		} catch (SQLException e) {
			System.out.println("Erro em adicionar ao histórico: " + e.getMessage());
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}
	}

	public ArrayList<Espaco_equipamento> getAllEspEq() {
		ArrayList<Espaco_equipamento> lisEspEq = new ArrayList<>();

		String sql = "SELECT * FROM historico_reserva";
		try {
			conexao = BancoConexaoDAO.getConexao();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Espaco_equipamento hr = new Espaco_equipamento();
				hr.setId(rs.getLong("id"));
				hr.setId_espaco(rs.getInt("id_espaco"));
				hr.setId_equipamento(rs.getInt("id_equipamento"));
				hr.setQuantidade(rs.getInt("quantidade"));

				lisEspEq.add(hr);
			}
			rs.close();
			return lisEspEq;

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			return null;
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}
	}
}