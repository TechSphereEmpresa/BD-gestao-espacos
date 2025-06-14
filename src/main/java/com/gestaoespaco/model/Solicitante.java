package com.gestaoespaco.model;

public class Solicitante {

	private Long id;
	private String nome;
	private String email;
	private String perfil;

	public Solicitante() {
	}

	public Solicitante(String nome, String email, String perfil) {
		this.nome = nome;
		this.email = email;
		this.perfil = perfil;
	}
	
	public Solicitante(Long id, String nome, String email, String perfil) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.perfil = perfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

}
