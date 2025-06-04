package com.gestaoespaco.model;

import java.time.LocalDateTime;

public class Solicitacao {
	private Long id;
	private Espaco espaco;
	private Solicitante solicitante;
	private LocalDateTime dataSolicitacao;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private String motivo;

	public Solicitacao() {
	}

	public Solicitacao(Long id, Espaco espaco, Solicitante solicitante, LocalDateTime dataSolicitacao,
			LocalDateTime inicio, LocalDateTime fim, String motivo) {
		this.id = id;
		this.espaco = espaco;
		this.solicitante = solicitante;
		this.dataSolicitacao = dataSolicitacao;
		this.inicio = inicio;
		this.fim = fim;
		this.motivo = motivo;
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

	public LocalDateTime getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getFim() {
		return fim;
	}

	public void setFim(LocalDateTime fim) {
		this.fim = fim;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}