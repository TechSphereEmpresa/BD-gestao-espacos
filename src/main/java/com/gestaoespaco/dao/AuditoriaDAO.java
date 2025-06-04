package com.gestaoespaco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gestaoespaco.model.Auditoria;
import com.gestaoespaco.model.Solicitacao;

public class AuditoriaDAO {
	private Connection conexao = null;

	public AuditoriaDAO() {
		conexao = BancoConexaoDAO.getConexao();
	}

	public void inserirAuditoria(Auditoria auditoria) {
		String sql = "INSERT INTO auditoria (id_solicitacao, data_acao, tipo_acao, tabela_afetada, id_registro_afetado, detalhes_acao) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			conexao = BancoConexaoDAO.getConexao();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, auditoria.getSolicitacao().getId());
			stmt.setTimestamp(2, auditoria.getDataAcao());
			stmt.setString(3, auditoria.getTipoAcao());
			stmt.setString(4, auditoria.getTabelaAfetada());
			stmt.setInt(5, auditoria.getIdRegistroAfetado());
			stmt.setString(6, auditoria.getDetalhesAcao());
			stmt.executeUpdate();
			stmt.close();
			System.out.println("Auditoria inserida com sucesso.");
		} catch (Exception e) {
			System.out.println("Erro ao inserir auditoria: " + e.getMessage());
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}
	}

	public List<Auditoria> listarAuditorias() {
		List<Auditoria> lista = new ArrayList<>();
		String sql = "SELECT * FROM auditoria";
		try {
			conexao = BancoConexaoDAO.getConexao();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Auditoria auditoria = new Auditoria();
				auditoria.setId(rs.getLong("id"));
				Solicitacao solicitacao = new Solicitacao();
				solicitacao.setId(rs.getLong("id_solicitacao"));
				auditoria.setSolicitacao(solicitacao);
				auditoria.setDataAcao(rs.getTimestamp("data_acao"));
				auditoria.setTipoAcao(rs.getString("tipo_acao"));
				auditoria.setTabelaAfetada(rs.getString("tabela_afetada"));
				auditoria.setIdRegistroAfetado(rs.getInt("id_registro_afetado"));
				auditoria.setDetalhesAcao(rs.getString("detalhes_acao"));
				lista.add(auditoria);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Erro ao listar auditorias: " + e.getMessage());
		} finally {
			BancoConexaoDAO.fecharConexao(conexao);
		}
		return lista;
	}
}
