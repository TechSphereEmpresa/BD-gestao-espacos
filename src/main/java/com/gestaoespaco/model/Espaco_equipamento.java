package com.gestaoespaco.model;

public class Espaco_equipamento {

	private Long id;
	private Integer id_espaco;
	private Integer id_equipamento;
	private Integer quantidade;

	public Espaco_equipamento() {
	}

	public Espaco_equipamento(Long id, Integer id_espaco, Integer id_equipamento, Integer quantidade) {
		this.id = id;
		this.id_espaco = id_espaco;
		this.id_equipamento = id_equipamento;
		this.quantidade = quantidade;
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

	public Integer getId_equipamento() {
		return id_equipamento;
	}

	public void setId_equipamento(Integer id_equipamento) {
		this.id_equipamento = id_equipamento;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
