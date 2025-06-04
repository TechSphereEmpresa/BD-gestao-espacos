package com.gestaoespaco.model;

public class Historico_reserva {

	private Long id;
	private String acao;

	private Solicitante solicitante;

	public Historico_reserva() {
	}

	public Historico_reserva(Long id, String acao, Solicitante solicitante) {
		this.id = id;
		this.acao = acao;
		this.solicitante = solicitante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

}
