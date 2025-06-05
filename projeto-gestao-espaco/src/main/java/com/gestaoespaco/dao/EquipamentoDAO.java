package com.gestaoespaco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gestaoespaco.model.Equipamento;

public class EquipamentoDAO {
	private Connection conexao = null;

	public EquipamentoDAO() {
		conexao = BancoConexaoDAO.getConexao();
	}

	public void inserirEquipamento(Equipamento equipamento) {
		String sql = "INSERT INTO equipamento (nome) VALUES (?)";
		try {
			conexao = BancoConexaoDAO.getConexao();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, equipamento.getNome());
			stmt.executeUpdate();
			stmt.close();
			System.out.println("Equipamento inserido com sucesso.");
		} catch (Exception e) {
			System.out.println("Erro ao inserir equipamento: " + e.getMessage());
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}
	}

	public List<Equipamento> listarEquipamentos() {
		List<Equipamento> lista = new ArrayList<>();
		String sql = "SELECT * FROM equipamento";
		try {
			conexao = BancoConexaoDAO.getConexao();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Equipamento equipamento = new Equipamento();
				equipamento.setId(rs.getLong("id"));
				equipamento.setNome(rs.getString("nome"));
				lista.add(equipamento);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Erro ao listar equipamentos: " + e.getMessage());
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}
		return lista;
	}
}
