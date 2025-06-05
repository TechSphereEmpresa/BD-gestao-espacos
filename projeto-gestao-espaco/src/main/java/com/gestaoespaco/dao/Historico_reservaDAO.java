package com.gestaoespaco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//colocar o import 
import com.gestaoespaco.model.Historico_reserva;

public class Historico_reservaDAO {
	private Connection conexao = null;

	public Historico_reservaDAO() {
		conexao = BancoConexaoDAO.getConexao();
	}

	public void addHisRes(Historico_reserva historico) {
		String sql = "INSERT INTO historico_reserva (id_solicitacao, acao) VALUES (?, ?)";
		// query para adicionar o espaço
		conexao = BancoConexaoDAO.getConexao();

		try {
			// o preparedStatement é para preparar a query, substituindo os valores dos ?
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, historico.getId_solicitacao());
			stmt.setString(2, historico.getAcao());
			stmt.executeUpdate();
			stmt.close();
			System.out.println("Histórico de reserva adicionado com sucesso:");
		} catch (SQLException e) {
			System.out.println("Erro em adicionar ao histórico: " + e.getMessage());
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}
	}

	public ArrayList<Historico_reserva> getAllHisRes() {
		ArrayList<Historico_reserva> lisHisRes = new ArrayList<>();

		String sql = "SELECT * FROM historico_reserva";
		try {
			conexao = BancoConexaoDAO.getConexao();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Historico_reserva hr = new Historico_reserva();
				hr.setId(rs.getLong("id"));
				hr.setId_solicitacao(rs.getInt("id_solicitacao"));
				hr.setAcao(rs.getString("acao"));

				lisHisRes.add(hr);
			}
			rs.close();
			return lisHisRes;

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			return null;
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}
	}
}