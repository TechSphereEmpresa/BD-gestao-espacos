package com.gestaoespaco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gestaoespaco.model.Solicitacao;

public class SolicitacaoDAO {

	private Connection conexao = null;

	public SolicitacaoDAO() {
		conexao = BancoConexaoDAO.getConexao();
	}

	public void addSolicitacao(Solicitacao sao) {

		String sql = "INSERT INTO solicitacao (id_espaco, id_solicitante, data_solicitacao, inicio, fim, motivo, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

		// query para adicionar o espaço
		conexao = BancoConexaoDAO.getConexao();

		try {
			// o preparedStatement é para preparar a query, substituindo os valores dos ?
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, sao.getId_espaco());
			stmt.setInt(2, sao.getId_solicitante());
			stmt.setTimestamp(3, sao.getDataSolicitacao());
			stmt.setTimestamp(4, sao.getInicio());
			stmt.setTimestamp(5, sao.getFim());
			stmt.setString(6, sao.getMotivo());
			stmt.setBoolean(7, sao.getStatus());

			// executar query
			stmt.execute();
			System.out.println("Solicitação adicionada no banco");

		} catch (SQLException e) {
			System.out.println("Erro em adicionar solicitação: " + e);
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}

	}

	public ArrayList<Solicitacao> getAllSolicitacoes() {
		ArrayList<Solicitacao> listSolicitacao = new ArrayList<>();

		String sql = "SELECT * FROM solicitacao";

		try {
			conexao = BancoConexaoDAO.getConexao();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Solicitacao sao = new Solicitacao();
				sao.setId_espaco(rs.getInt("id_espaco"));
				sao.setId_solicitante(rs.getInt("id_solicitante"));
				sao.setDataSolicitacao(rs.getTimestamp("data_solicitacao"));
				sao.setInicio(rs.getTimestamp("inicio"));
				sao.setFim(rs.getTimestamp("fim"));
				sao.setMotivo(rs.getString("motivo"));
				sao.setStatus(rs.getBoolean("status"));

				listSolicitacao.add(sao);
			}

			rs.close();
			return listSolicitacao;

		} catch (Exception e) {
			System.out.println("Erro: " + e);
			return null;
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}
	}
}
