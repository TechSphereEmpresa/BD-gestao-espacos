package com.gestaoespaco.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.gestaoespaco.model.Solicitacao;
public class SolicitacaoDAO {
		
	private Connection conexao = null;
	
	public SolicitacaoDAO() {
		conexao = BancoConexaoDAO.getConexao();
	}
	
	public void addSolicitacao(Solicitacao sao) {
		
		String sql = "INSERT INTO solicitacao (data_solicitacao, data_inicio, data_fim, horario_inicio, horario_fim, motivo, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		// query para adicionar o espaço
		conexao = BancoConexaoDAO.getConexao();
		
		try {
			// o preparedStatement é para preparar a query, substituindo os valores dos ?
			PreparedStatement stmt = conexao.prepareStatement(sql);
			//stmt.setLong(1, sao.getId());
			stmt.setTimestamp(1, Timestamp.valueOf(sao.getDataSolicitacao()));
			stmt.setTimestamp(2, Timestamp.valueOf(sao.getInicio()));
			stmt.setTimestamp(3, Timestamp.valueOf(sao.getFim()));
			stmt.setString(4, sao.getMotivo());
			stmt.setBoolean(5, sao.getStatus());
			
			// executar query
			stmt.execute();
			System.out.println("Solicitação adicionado no banco");
			
		} catch (SQLException e) {
			System.out.println("Erro em adicionar solicitação: " + e);
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}
	}
	{
		
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
				sao.setDataSolicitacao(rs.getTimestamp("data_solicitacao").toLocalDateTime());
				sao.setInicio(rs.getTimestamp("inicio").toLocalDateTime());
				sao.setFim(rs.getTimestamp("fim").toLocalDateTime());
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

