package com.gestaoespaco.model;

import java.sql.Timestamp;

public class Solicitacao {
	private Long id;
	private Espaco espaco;
	private Solicitante solicitante;
	private Timestamp dataSolicitacao;
	private Timestamp inicio;
	private Timestamp fim;
	private String motivo;
	private boolean status;

	public Solicitacao() {
	}

	public Solicitacao(Long id, Espaco espaco, Solicitante solicitante, Timestamp dataSolicitacao,
			Timestamp inicio, Timestamp fim, String motivo, boolean status) {
		this.id = id;
		this.espaco = espaco;
		this.solicitante = solicitante;
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

	public Espaco getEspaco() {
		return espaco;
	}

	public void setEspaco(Espaco espaco) {
		this.espaco = espaco;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
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