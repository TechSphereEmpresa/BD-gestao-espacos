package com.gestaoespaco.model;

import java.sql.Timestamp;

public class Solicitacao {
	private Long id;
	private Integer id_espaco;
	private Integer id_solicitante;
	private Timestamp dataSolicitacao;
	private Timestamp inicio;
	private Timestamp fim;
	private String motivo;
	private boolean status;

	public Solicitacao() {
	}

	public Solicitacao(Integer id_espaco, Integer id_solicitante, Timestamp dataSolicitacao, Timestamp inicio,
			Timestamp fim, String motivo, boolean status) {
		this.id_espaco = id_espaco;
		this.id_solicitante = id_solicitante;
		this.dataSolicitacao = dataSolicitacao;
		this.inicio = inicio;
		this.fim = fim;
		this.motivo = motivo;
		this.status = status;
	}

	public Solicitacao(Long id, Integer id_espaco, Integer id_solicitante, Timestamp dataSolicitacao, Timestamp inicio,
			Timestamp fim, String motivo, boolean status) {
		this.id = id;
		this.id_espaco = id_espaco;
		this.id_solicitante = id_solicitante;
		this.dataSolicitacao = dataSolicitacao;
		this.inicio = inicio;
		this.fim = fim;
		this.motivo = motivo;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getId_espaco() {
		return id_espaco;
	}

	public void setId_espaco(Integer id_espaco) {
		this.id_espaco = id_espaco;
	}

	public Integer getId_solicitante() {
		return id_solicitante;
	}

	public void setId_solicitante(Integer id_solicitante) {
		this.id_solicitante = id_solicitante;
	}

	public Timestamp getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Timestamp dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Timestamp getInicio() {
		return inicio;
	}

	public void setInicio(Timestamp inicio) {
		this.inicio = inicio;
	}

	public Timestamp getFim() {
		return fim;
	}

	public void setFim(Timestamp fim) {
		this.fim = fim;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}