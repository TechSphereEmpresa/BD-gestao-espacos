package com.gestaoespaco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gestaoespaco.model.Espaco;

public class EspacoDAO {

	private Connection conexao = null;

	public EspacoDAO() {
		conexao = BancoConexaoDAO.getConexao();
	}

	public void addEspaco(Espaco esp) {

		String sql = "INSERT INTO espaco (nome, tipo, localizacao, metragem, capacidade) VALUES (?, ?, ?, ?, ?)";

		// query para adicionar o espaço
		conexao = BancoConexaoDAO.getConexao();

		try {
			// o preparedStatement é para preparar a query, substituindo os valores dos ?
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, esp.getNome());
			stmt.setString(2, esp.getTipo());
			stmt.setString(3, esp.getLocalizacao());
			stmt.setDouble(4, esp.getMetragem());
			stmt.setInt(5, esp.getCapacidade());

			// executar query
			stmt.execute();
			System.out.println("Espaço adicionado no banco");

		} catch (SQLException e) {
			System.out.println("Erro em adicionar espaço" + e);
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}
	}

	public ArrayList<Espaco> getAllEspacos() {

		ArrayList<Espaco> listEspaco = new ArrayList<>();

		String sql = "SELECT * FROM espaco";

		try {
			conexao = BancoConexaoDAO.getConexao();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Espaco esp = new Espaco();
				esp.setNome(rs.getString("nome"));
				esp.setTipo(rs.getString("tipo"));
				esp.setLocalizacao(rs.getString("localizacao"));
				esp.setMetragem(rs.getDouble("metragem"));
				esp.setCapacidade(rs.getInt("capacidade"));

				listEspaco.add(esp);
			}

			rs.close();
			return listEspaco;

		} catch (Exception e) {
			System.out.println("Erro: " + e);
			return null;
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}
	}

}