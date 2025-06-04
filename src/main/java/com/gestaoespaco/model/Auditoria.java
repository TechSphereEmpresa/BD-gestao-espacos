package com.gestaoespaco.model;

import java.sql.Timestamp;

public class Auditoria {
	private Long id;
	private Integer id_solicitacao;
	private Timestamp dataAcao;
	private String tipoAcao;
	private String tabelaAfetada;
	private int idRegistroAfetado;
	private String detalhesAcao;

	public Auditoria() {
	}

	public Auditoria(Integer id_solicitacao, Timestamp dataAcao, String tipoAcao, String tabelaAfetada,
			int idRegistroAfetado, String detalhesAcao) {
		this.id_solicitacao = id_solicitacao;
		this.dataAcao = dataAcao;
		this.tipoAcao = tipoAcao;
		this.tabelaAfetada = tabelaAfetada;
		this.idRegistroAfetado = idRegistroAfetado;
		this.detalhesAcao = detalhesAcao;
	}
	
	public Auditoria(Long id, Integer id_solicitacao, Timestamp dataAcao, String tipoAcao, String tabelaAfetada,
			int idRegistroAfetado, String detalhesAcao) {
		super();
		this.id = id;
		this.id_solicitacao = id_solicitacao;
		this.dataAcao = dataAcao;
		this.tipoAcao = tipoAcao;
		this.tabelaAfetada = tabelaAfetada;
		this.idRegistroAfetado = idRegistroAfetado;
		this.detalhesAcao = detalhesAcao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getId_solicitacao() {
		return id_solicitacao;
	}

	public void setId_solicitacao(Integer id_solicitacao) {
		this.id_solicitacao = id_solicitacao;
	}

	public Timestamp getDataAcao() {
		return dataAcao;
	}

	public void setDataAcao(Timestamp dataAcao) {
		this.dataAcao = dataAcao;
	}

	public String getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(String tipoAcao) {
		this.tipoAcao = tipoAcao;
	}

	public String getTabelaAfetada() {
		return tabelaAfetada;
	}

	public void setTabelaAfetada(String tabelaAfetada) {
		this.tabelaAfetada = tabelaAfetada;
	}

	public int getIdRegistroAfetado() {
		return idRegistroAfetado;
	}

	public void setIdRegistroAfetado(int idRegistroAfetado) {
		this.idRegistroAfetado = idRegistroAfetado;
	}

	public String getDetalhesAcao() {
		return detalhesAcao;
	}

	public void setDetalhesAcao(String detalhesAcao) {
		this.detalhesAcao = detalhesAcao;
	}

}