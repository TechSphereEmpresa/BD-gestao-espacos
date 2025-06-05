package com.gestaoespaco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gestaoespaco.model.Avaliacao_gestor;
import com.gestaoespaco.model.Gestor;
import com.gestaoespaco.model.Solicitacao;


public class Avaliacao_gestorDAO {

	private Connection conexao = null;

	public Avaliacao_gestorDAO() {
       conexao = BancoConexaoDAO.getConexao();
   }

	public void addAvaliacao(Avaliacao_gestor avaliacao) {
		String sql = "INSERT INTO avaliacao_gestor (id_gestor, id_solicitacao, status) VALUES (?, ?, ?)";
		try {
			conexao = BancoConexaoDAO.getConexao();

			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, avaliacao.getGestor().getId());
			stmt.setLong(2, avaliacao.getSolicitacao().getId());
			stmt.setBoolean(3, avaliacao.getStatus());
			stmt.executeUpdate();
			stmt.close();

			System.out.println("Avaliação do gestor adicionada com sucesso.");
		} catch (SQLException e) {
			System.out.println("Erro ao adicionar avaliação: " + e.getMessage());
		} finally {

			BancoConexaoDAO.fecharConexao(conexao);

		}
	}

	public ArrayList<Avaliacao_gestor> getAllAvaliacoes() {
       ArrayList<Avaliacao_gestor> lista = new ArrayList<>();
      
       String sql = "SELECT * FROM avaliacao_gestor";
       try {
           conexao = BancoConexaoDAO.getConexao();
           PreparedStatement stmt = conexao.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery();
           while (rs.next()) {
             
           	Avaliacao_gestor ag = new Avaliacao_gestor();
               ag.setId(rs.getLong("id"));
               Gestor g = new Gestor();
               g.setId(rs.getLong("id_gestor"));
               ag.setGestor(g);
               Solicitacao s = new Solicitacao();
               s.setId(rs.getLong("id_solicitacao"));
               ag.setSolicitacao(s);
               ag.setStatus(rs.getBoolean("status"));
               lista.add(ag);
           }
           rs.close();
           return lista;
       } catch (Exception e) {
           System.out.println("Erro ao listar avaliações: " + e.getMessage());
           return null;
       } finally {
           BancoConexaoDAO.fecharConexao(conexao);
       }
   }
}