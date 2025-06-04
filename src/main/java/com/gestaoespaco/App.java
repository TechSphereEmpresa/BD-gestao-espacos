package com.gestaoespaco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    private static final String URL = "jdbc:postgresql://localhost:5432/espaco_gerenciador_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgre1234";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            
            // Inicializar serviços e controllers aqui
            
            connection.close();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}