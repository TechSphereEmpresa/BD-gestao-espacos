package com.gestaoespaco.model;

public class Espaco_equipamento {

	private Long id;
	private Espaco espaco;
	private Equipamento equipamento;
	private int quantidade;

	public Espaco_equipamento() {
	}

	public Espaco_equipamento(Long id, Espaco espaco, Equipamento equipamento, int quantidade) {
		this.id = id;
		this.espaco = espaco;
		this.equipamento = equipamento;
		this.quantidade = quantidade;
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

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
