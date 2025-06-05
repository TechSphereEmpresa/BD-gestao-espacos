package com.gestaoespaco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gestaoespaco.model.Solicitante;

public class SolicitanteDAO {

	private Connection conexao = null;

	public SolicitanteDAO() {
		conexao = BancoConexaoDAO.getConexao();
	}

	public void addSolicitante(Solicitante sol) {

		String sql = "INSERT INTO solicitante (nome, email, perfil) VALUES (?, ?, ?)";

		// query para adicionar o espaço
		conexao = BancoConexaoDAO.getConexao();

		try {
			// o preparedStatement é para preparar a query, substituindo os valores dos ?
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, sol.getNome());
			stmt.setString(2, sol.getEmail());
			stmt.setString(3, sol.getPerfil());

			// executar query
			stmt.execute();
			System.out.println("Solicitante adicionado no banco");

		} catch (SQLException e) {
			System.out.println("Erro em adicionar solicitante: " + e);
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}
	}

	public ArrayList<Solicitante> getAllSolicitantes() {
		ArrayList<Solicitante> listSolicitante = new ArrayList<>();

		String sql = "SELECT * FROM solicitante";

		try {
			conexao = BancoConexaoDAO.getConexao();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Solicitante sol = new Solicitante();
				sol.setId(rs.getLong("id"));
				sol.setNome(rs.getString("nome"));
				sol.setEmail(rs.getString("email"));
				sol.setPerfil(rs.getString("perfil"));

				listSolicitante.add(sol);
			}

			rs.close();
			return listSolicitante;

		} catch (Exception e) {
			System.out.println("Erro: " + e);
			return null;
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}
	}
}