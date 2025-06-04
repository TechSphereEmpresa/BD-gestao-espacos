package com.gestaoespaco.model;

public class Historico_reserva {

	private Long id;
	private String acao;
	private Integer id_solicitacao;

	public Historico_reserva() {
	}

	public Historico_reserva(Integer id_solicitacao , String acao) {
		this.id_solicitacao = id_solicitacao;
		this.acao = acao;
	}
	
	public Historico_reserva(Long id, Integer id_solicitacao , String acao) {
		this.id = id;
		this.id_solicitacao = id_solicitacao;
		this.acao = acao;
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

	public Integer getId_solicitacao() {
		return id_solicitacao;
	}

	public void setId_solicitacao(Integer id_solicitacao) {
		this.id_solicitacao = id_solicitacao;
	}

}