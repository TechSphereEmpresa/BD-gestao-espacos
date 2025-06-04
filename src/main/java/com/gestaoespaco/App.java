package com.gestaoespaco;

import java.util.Scanner;

import com.gestaoespaco.dao.EspacoDAO;
import com.gestaoespaco.dao.SolicitanteDAO;
import com.gestaoespaco.model.Espaco;
import com.gestaoespaco.model.Solicitante;

public class App {

	public static void main(String[] args) {

		App app = new App();
		app.menu();
	}

	public Scanner getScanner() {
		return new Scanner(System.in);
	}

	public void menu() {

		System.out.println("1) Cadastrar Espaço");
		System.out.println("2) Listar todos os espaços");

		System.out.print("Opção: ");
		int op = getScanner().nextInt();

		switch (op) {

		case 1:
			addEspaco();
		case 2:
			getAllEspacos();
		default:
			System.out.println("Digite uma opção valida!");
			menu();
		}
	}

	private void addEspaco() {

		System.out.print("Nome do espaço: ");
		String nome = getScanner().nextLine();

		System.out.print("Tipo: ");
		String tipo = getScanner().next();

		System.out.print("Localização: ");
		String localizacao = getScanner().nextLine();

		System.out.print("Metragem: ");
		double metragem = getScanner().nextDouble();

		System.out.print("Capacidade: ");
		int capacidade = getScanner().nextInt();

		// Instanciando espaço
		Espaco esp = new Espaco(nome, tipo, localizacao, metragem, capacidade);

		// Instanciando a classe DAO do espaco, chamando o metodo addEspaco e passando
		// como parametro o espaco
		EspacoDAO espDAO = new EspacoDAO();
		espDAO.addEspaco(esp);

	}

	public void getAllEspacos() {

		// Instanciando a classe DAO do Carro
		EspacoDAO espDAO = new EspacoDAO();

		System.out.println("\t\n--- Todos os espaços ---\n");

		// Passando um for no arraylist que o metodo mostrar_carros retorna
		for (Espaco e : espDAO.getAllEspacos()) {
			System.out.println("Id: " + e.getId());
			System.out.println("Nome: " + e.getNome());
			System.out.println("Tipo: " + e.getTipo());
			System.out.println("Localização: " + e.getLocalizacao());
			System.out.println("Metragem: " + e.getMetragem());
			System.out.println("Capacidade: " + e.getCapacidade() + "\n");
		}
	}

//	private void addSolicitante() {
//		System.out.print("Nome do solicitante: ");
//		String nome = getScanner().nextLine();
//
//		System.out.print("Email: ");
//		String email = getScanner().next();
//
//		System.out.print("Perfil: ");
//		String perfil = getScanner().nextLine();
//
//		// Instanciando solicitante
//		Solicitante sol = new Solicitante(nome, email, perfil);
//
//		// Instanciando a classe DAO do solicitante, chamando o metodo e passando como
//		// parametro o solicitante
//		SolicitanteDAO solDAO = new SolicitanteDAO();
//		solDAO.addSolicitante(sol);
//	}

	public void getAllSolicitantes() {
		// Instanciando a classe DAO
		SolicitanteDAO solDAO = new SolicitanteDAO();
		System.out.println("\t\n--- Todos os solicitantes ---\n");
		// Passando um for no arraylist
		for (Solicitante e : solDAO.getAllSolicitantes()) {
			System.out.println("Id: " + e.getId());
			System.out.println("Nome: " + e.getNome());
			System.out.println("Email: " + e.getEmail());
			System.out.println("Perfil: " + e.getPerfil() + "\n");
		}
	}

}