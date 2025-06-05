package com.gestaoespaco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gestaoespaco.model.Gestor;

public class GestorDAO {

private Connection conexao = null;
	
	public GestorDAO() {
		conexao = BancoConexaoDAO.getConexao();
	}
	
	public void addGestor(Gestor gst) {
		
		String sql = "INSERT INTO gestor (nome, email) VALUES (?, ?)";
		
		// query para adicionar o espaço
		conexao = BancoConexaoDAO.getConexao();
		
		try {
			// o preparedStatement é para preparar a query, substituindo os valores dos ?
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, gst.getNome());
			stmt.setString(2, gst.getEmail());
			
			// executar query
			stmt.execute();
			System.out.println("Gestor adicionado no banco");
			
		} catch (SQLException e) {
			System.out.println("Erro em adicionar gestor: " + e);
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}
	}
	
	public ArrayList<Gestor> getAllGestores() {
		ArrayList<Gestor> listGestor = new ArrayList<>();
		
		String sql = "SELECT * FROM gestor";
		
		try {
			conexao = BancoConexaoDAO.getConexao();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Gestor gst = new Gestor();
				gst.setId(rs.getLong("id"));
				gst.setNome(rs.getString("nome"));
				gst.setEmail(rs.getString("email"));
				
				listGestor.add(gst);
			}
			
			rs.close();
			return listGestor;
			
		} catch (Exception e) {
			 System.out.println("Erro: " + e);
	         return null;
		} finally {
           BancoConexaoDAO.fecharConexao(conexao);
       }
   }

}