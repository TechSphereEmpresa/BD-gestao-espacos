package com.gestaoespaco.repository;

import com.gestaoespaco.model.Solicitante;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolicitanteRepository {
    private Connection connection;
    
    public SolicitanteRepository(Connection connection) {
        this.connection = connection;
    }
    
    public List<Solicitante> findAllSolicitantes() throws SQLException {
        List<Solicitante> solicitantes = new ArrayList<>();
        String sql = "SELECT nome, email, perfil FROM solicitante";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
            	Solicitante solicitante = new Solicitante();
            	solicitante.setNome(rs.getString("nome"));
            	solicitante.setEmail(rs.getString("email"));
            	solicitante.setPerfil(rs.getString("telefone"));
            }
        }
        return solicitantes;
    }
    
    // Outros métodos CRUD
}