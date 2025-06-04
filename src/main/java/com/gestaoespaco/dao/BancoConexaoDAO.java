package com.gestaoespaco.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoConexaoDAO {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/espaco_gerenciador_db";
	private static final String USER = "postgres";
	private static final String PASS = "postgre1234";
	    
	public static Connection getConexao() {
		try {
			return DriverManager.getConnection(URL, USER, PASS);
			
		} catch (SQLException e) {
			System.out.println("Erro ao conectar o banco");
			e.printStackTrace();
			return null;
		}
	}
	
	public static void fecharConexao (Connection conexao) {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (Exception e) {
				System.out.println("Erro em fechar conexão " + e);
			}
		}
	}
	
}