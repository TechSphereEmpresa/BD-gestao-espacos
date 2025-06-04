package com.gestaoespaco;

import java.security.Timestamp;
import java.util.Scanner;

import com.gestaoespaco.dao.EquipamentoDAO;
import com.gestaoespaco.dao.EspacoDAO;
import com.gestaoespaco.dao.Espaco_equipamentoDAO;
import com.gestaoespaco.dao.GestorDAO;
import com.gestaoespaco.dao.Historico_reservaDAO;
import com.gestaoespaco.dao.SolicitacaoDAO;
import com.gestaoespaco.dao.SolicitanteDAO;
import com.gestaoespaco.model.Equipamento;
import com.gestaoespaco.model.Espaco;
import com.gestaoespaco.model.Espaco_equipamento;
import com.gestaoespaco.model.Gestor;
import com.gestaoespaco.model.Historico_reserva;
import com.gestaoespaco.model.Solicitacao;
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

	// METODOS AUDITORIA

//	private void addAuditoria() {
//		System.out.print("ID da Solicitação: ");
//		int id_solicitacao = getScanner().nextInt();
//		
//		getScanner().nextLine(); // Pra limpar o buffer
//		System.out.print("Data e hora (formato 'yyyy-MM-dd HH:mm:ss') da ação: ");
//		String data = getScanner().nextLine();
//		Instant instant = Instant.parse(data + "Z");
//        long dataAcao = instant.toEpochMilli();
//		
//		System.out.print("Tipo da ação: ");
//		String tipoAcao = getScanner().nextLine();
//		
//		System.out.print("Tabela afetada: ");
//		String tabelaAfetada = getScanner().nextLine();
//		
//		System.out.print("ID do registro afetado: ");
//		int idRegistroAfetado = getScanner().nextInt();
//		
//		System.out.print("Detalhes da ação: ");
//		String detalhes = getScanner().nextLine();
//		
//		Auditoria auditoria = new Auditoria(id_solicitacao, dataAcao, tipoAcao, tabelaAfetada, idRegistroAfetado, detalhesAcao);
//		AuditoriaDAO auditoriaDAO = new AuditoriaDAO();
//		auditoriaDAO.inserirAuditoria(auditoria);
//	}
//
//	public void getAllAuditorias() {
//		AuditoriaDAO auditoriaDAO = new AuditoriaDAO();
//		System.out.println("\t\n--- Todas as Auditorias ---\n");
//		for (Auditoria a : auditoriaDAO.listarAuditorias()) {
//			System.out.println("ID: " + a.getId());
//			System.out.println("ID Solicitação: " + a.getSolicitacao().getId());
//			System.out.println("Data da Ação: " + a.getDataAcao());
//			System.out.println("Tipo de Ação: " + a.getTipoAcao());
//			System.out.println("Tabela Afetada: " + a.getTabelaAfetada());
//			System.out.println("ID Registro Afetado: " + a.getIdRegistroAfetado());
//			System.out.println("Detalhes da Ação: " + a.getDetalhesAcao() + "\n");
//		}
//	}

	// METODOS AVALIACAO_GESTOR

	// METODOS EQUIPAMENTO

	private void addEquipamento() {
		System.out.print("Nome do equipamento: ");
		String nome = getScanner().nextLine();
		Equipamento equipamento = new Equipamento(nome);
		EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
		equipamentoDAO.inserirEquipamento(equipamento);
	}

	public void getAllEquipamentos() {

		EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
		System.out.println("\t\n--- Todos os equipamentos ---\n");
		for (Equipamento e : equipamentoDAO.listarEquipamentos()) {
			System.out.println("Id: " + e.getId());
			System.out.println("Nome: " + e.getNome() + "\n");
		}
	}

	// METODOS ESPACO_EQUIPAMENTO

	private void salvarEspacoEquipamento() {
		try {
			System.out.print("ID do Espaço: ");
			int id_espaco = getScanner().nextInt();

			System.out.print("ID do Equipamento: ");
			int id_equipamento = getScanner().nextInt();

			System.out.print("Quantidade: ");
			int quantidade = Integer.parseInt(getScanner().nextLine());

			// Criando objeto Espaco_Equipamento
			Espaco_equipamento espacoEquipamento = new Espaco_equipamento();
			espacoEquipamento.setId_espaco(id_espaco);
			espacoEquipamento.setId_equipamento(id_equipamento);
			espacoEquipamento.setQuantidade(quantidade);

			// Persistindo o objeto no banco
			Espaco_equipamentoDAO dao = new Espaco_equipamentoDAO();
			dao.addEspEq(espacoEquipamento);

			System.out.println("Espaço e Equipamento salvos com sucesso!");

		} catch (NumberFormatException e) {
			System.out.println("Erro: formato de número inválido.");
		} catch (Exception e) {
			System.out.println("Erro ao salvar Espaço e Equipamento: " + e.getMessage());
		}
	}

	// METODOS ESPACO

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

	// METODOS GESTOR

	private void addGestor() {
		System.out.print("Nome do gestor: ");
		String nome = getScanner().nextLine();

		System.out.print("Email: ");
		String email = getScanner().next();

		// Instanciando gestor
		Gestor gst = new Gestor(nome, email);

		// Instanciando a classe DAO do gestor, chamando o metodo e passando como
		// parametro o gestor
		GestorDAO gstDAO = new GestorDAO();
		gstDAO.addGestor(gst);
	}

	public void getAllGestores() {
		// Instanciando a classe DAO
		GestorDAO gstDAO = new GestorDAO();
		System.out.println("\t\n--- Todos os gestores ---\n");
		// Passando um for no arraylist
		for (Gestor e : gstDAO.getAllGestores()) {
			System.out.println("Id: " + e.getId());
			System.out.println("Nome: " + e.getNome());
			System.out.println("Email: " + e.getEmail() + "\n");
		}
	}

	// METODOS HISTORICO_RESERVA

	private void addHistorico_reserva() {
		System.out.print("ID da solicitação: ");
		int id_solicitacao = getScanner().nextInt();

		System.out.print("ID da solicitação: ");
		String acao = getScanner().next();

		// Instanciando Historico_reservaa
		Historico_reserva historico = new Historico_reserva(id_solicitacao, acao);

		// Instanciando a classe DAO e chamando o metodo e passando como parametro o
		// Historico_reserva
		Historico_reservaDAO dao = new Historico_reservaDAO();
		dao.addHisRes(historico);
		;
	}

	public void getAllHistorico_reserva() {
		Historico_reservaDAO dao = new Historico_reservaDAO();
		System.out.println("\n--- Histórico de Reservas ---\n");
		for (Historico_reserva hr : dao.getAllHisRes()) {
			System.out.println("ID: " + hr.getId());
			System.out.println("ID Solicitação: " + hr.getId_solicitacao());
			System.out.println("Ação: " + hr.getAcao());
		}
	}

	// METODOS SOLICITACAO

//	private void addSolicitacao() {
//		try {
//			System.out.print("Data da solicitação (yyyy-MM-dd): ");
//			String dataSolicStr = getScanner().nextLine();
//			java.sql.Date dataSolicitacao = java.sql.Date.valueOf(dataSolicStr);
//
//			System.out.print("Data de início (yyyy-MM-dd): ");
//			String dataInicioStr = getScanner().nextLine();
//			java.sql.Date dataInicio = java.sql.Date.valueOf(dataInicioStr);
//
//			System.out.print("Data de fim (yyyy-MM-dd): ");
//			String dataFimStr = getScanner().nextLine();
//			java.sql.Date dataFim = java.sql.Date.valueOf(dataFimStr);
//
//			System.out.print("Horário de início (HH:mm:ss): ");
//			String horarioInicioStr = getScanner().nextLine();
//			Timestamp horarioInicio = Timestamp.valueOf(dataInicioStr + " " + horarioInicioStr + ".000");
//
//			System.out.print("Horário de fim (HH:mm:ss): ");
//			String horarioFimStr = getScanner().nextLine();
//			Timestamp horarioFim = Timestamp.valueOf(dataFimStr + " " + horarioFimStr + ".000");
//
//			System.out.print("Motivo da solicitação: ");
//			String motivo = getScanner().nextLine();
//
//			System.out.print("Status (true para ativo / false para inativo): ");
//			boolean status = getScanner().nextBoolean();
//			getScanner().nextLine();
//
//			// Criar objeto e persistir
//			Solicitacao solicitacao = new Solicitacao();
//			solicitacao.setData_solicitacao(dataSolicitacao);
//			solicitacao.setData_inicio(dataInicio);
//			solicitacao.setData_fim(dataFim);
//			solicitacao.setHorario_inicio(horarioInicio);
//			solicitacao.setHorario_fim(horarioFim);
//			solicitacao.setMotivo(motivo);
//			solicitacao.setStatus(status);
//
//			SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
//			solicitacaoDAO.addSolicitacao(solicitacao);
//
//			System.out.println("Solicitação adicionada com sucesso!");
//
//		} catch (IllegalArgumentException e) {
//			System.out.println("Formato de data ou hora inválido. Use os padrões indicados.");
//		} catch (Exception e) {
//			System.out.println("Erro ao adicionar solicitação: " + e.getMessage());
//		}
//	}

	// METODOS SOLICITANTE
	
	private void addSolicitante() {
	       System.out.print("Nome do solicitante: ");
	       String nome = getScanner().nextLine();
	     
	       System.out.print("Email: ");
	       String email = getScanner().next();
	     
	       System.out.print("Perfil: ");
	       String perfil = getScanner().nextLine();
	     
	       //Instanciando solicitante
	       Solicitante sol = new Solicitante(nome, email, perfil);
	      
	       //Instanciando a classe DAO do solicitante, chamando o metodo e passando como parametro o solicitante
	       SolicitanteDAO solDAO = new SolicitanteDAO();
	       solDAO.addSolicitante(sol);
	   }
		
	public void getAllSolicitantes() {
	       //Instanciando a classe DAO
			SolicitanteDAO solDAO = new SolicitanteDAO();
	       System.out.println("\t\n--- Todos os solicitantes ---\n");
	       //Passando um for no arraylist
	       for (Solicitante e : solDAO.getAllSolicitantes()) {
	           System.out.println("Id: " + e.getId());
	           System.out.println("Nome: " + e.getNome());
	           System.out.println("Email: " + e.getEmail());
	           System.out.println("Perfil: " + e.getPerfil() + "\n");
	       }
	   }

}