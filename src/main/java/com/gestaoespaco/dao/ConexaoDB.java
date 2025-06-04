package com.gestaoespaco.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/espaco_gerenciador_db";
    private static final String USER = "postgres"; // Substitua pelo seu usuário do PostgreSQL
    private static final String PASSWORD = "postgre1234"; // Substitua pela sua senha do PostgreSQL

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Carrega o driver JDBC
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC do PostgreSQL não encontrado. Adicione ao classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão com o banco de dados fechada.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão com o banco de dados: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    // Método main para testar a conexão
    public static void main(String[] args) {
        Connection conn = ConexaoDB.getConnection();
        if (conn != null) {
            ConexaoDB.closeConnection(conn);
        }
    }
}