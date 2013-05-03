package main;

import java.util.ArrayList;
import java.util.Calendar;



import model.Atestado;
import model.Consulta;
import model.DeclaracaoAcompanhamento;
import model.DocumentoMedico;
import model.Medico;
import model.Paciente;
import model.Receita;
import model.Secretaria;
import model.TipoConvenio;
import model.tipoConsulta;
import persistencia.BD;
import service.ConsultaService;
import service.DocumentoMedicoService;
import service.FuncionarioService;
import service.PacienteService;

public class Main {
	public static void main(String[] args) {
//		Criando conexão com o Banco de Dados
		BD.getConnection();
		
//		Services
		FuncionarioService fs = new FuncionarioService();
		PacienteService ps = new PacienteService();
		ConsultaService	cs = new ConsultaService();
		DocumentoMedicoService dms = new DocumentoMedicoService();
		
//		Instanciação e Persistencia dos objetos:
		
//		Criando Secretárias
		Calendar c = Calendar.getInstance();
		c.set(1991, 12, 11);
		Secretaria s1 = new Secretaria("kamila", "123456789", 410520630, c,"Rua da abobora n 12" ,
				"33225511" ,"99885544" , "kamila@hotmail.com", "kml", "123", 0);
		fs.add(s1);
		
		Calendar c1 = Calendar.getInstance();
		c1.set(1984, 07, 01);
		Secretaria s2 = new Secretaria("Nathalia", "22554411", 41022214, c1, "rua do girassol",
				"66559988", "44551122", "nath@hotmail.com", "ntl", "456", 0);
		fs.add(s2);
		
//		Criando Médicos
		Calendar c2 = Calendar.getInstance();
		c2.set(1990, 11, 16);
		Medico m1 = new Medico("lucas", "1236548947", 45612253, c2, "rua dos desejos", "44555662", "11445569", "lucas@ig.com", "lcs", "789", 1, "cardiologia", "45678-sp");
		fs.add(m1);
		
		Calendar c3 = Calendar.getInstance();
		c3.set(1991, 05, 11);
		Medico m2 = new Medico("victor", "396052058", 41053382, c3, "rua bragança 372", "33242063", "98249095", "victor@matera.com", "vlp", "159", 1, "neurocirurgia", "12345-sp");
		fs.add(m2);
		
//		Criando Pacientes
		Calendar c4 = Calendar.getInstance();
		c4.set(1965, 13,13);
		Paciente p1 = new Paciente("rodrigo", "456123854", 456123, c4, "Rua fragata 987", "22554411", "", "", TipoConvenio.particular , "doença mental", "", "mudança de sexo");
		ps.add(p1);
		
		Calendar c5 = Calendar.getInstance();
		c5.set(1955, 12, 9);
		Paciente p2 = new Paciente("nathan", "11554489", 415452, c5, "rua fragata 98", "11223344", "44332211", "nathan@gordo", TipoConvenio.particular, "Excesso de gordura", "", "");
		ps.add(p2);
		
		Calendar c6 = Calendar.getInstance();
		c6.set(1980, 2, 3);
		Paciente p3 = new Paciente("Rubens", "45654654", 45544, c6, "rua do leite 22", "45455887", "", "", TipoConvenio.planoDeSaúde, "", "", "");
		ps.add(p3);
		
		
//		Criando Consultas:
		
//		Consultas
		Calendar h1 = Calendar.getInstance();
		h1.set(2013, 03, 19, 10, 30);
		Consulta con1 = new Consulta((Paciente) BD.pesquisaPessoa(456123),BD.pesquisaMedico("vlp"), h1, h1, tipoConsulta.normal);
		cs.add(con1);
		
		Calendar h2 = Calendar.getInstance();
		h2.set(2013, 03, 20, 8, 00);
		Consulta con2 = new Consulta((Paciente) BD.pesquisaPessoa(415452), BD.pesquisaMedico("vlp"), h2, h2, tipoConsulta.normal);
		cs.add(con2);
		
		Calendar h3 = Calendar.getInstance();
		h3.set(2013, 03, 21, 12, 15);
		Consulta con3 = new Consulta((Paciente) BD.pesquisaPessoa(45544), BD.pesquisaMedico("lcs"), h3, h3, tipoConsulta.normal);
		cs.add(con3);
		
//		Criando receita
		Receita rec1 = new Receita(p1, m1, "Diclofenaco de potácio....... 50mg.......2x ao dia\nStanozolol.......25mg.......1x ao dia",c1);
		dms.add(rec1);		
		
//		Criando Atestado
		Atestado atest1 = new Atestado(p2, m2, "Conjuntivite bacteriosa", h2, 5);
		dms.add(atest1);
		
//		Criando declaraçao de acompanhamento
		DeclaracaoAcompanhamento dAcom = new DeclaracaoAcompanhamento(p1, p3, m2, "Grandes amigos", h1);
		dms.add(dAcom);
		
//		Gerando Relatório de Consultas do dia seguinte
		ArrayList<Consulta> consultas;

		System.out.println("-------------------------------Consultas de amanha-------------------------------");
		try{
		consultas = ConsultaService.pesquisaConsultasDiaSeguinte();
				
		for (Consulta consulta : consultas) {
			System.out.println("idConsulta: "+ consulta.getId()+" - Nome do paciente: "+ consulta.getPaciente().getNome()+ " - Tel: "+ consulta.getPaciente().getTel()+"- Horário: "+consulta.getHorario()+" - Dr: "+consulta.getMedico().getNome());
		}
		System.out.println("*******************************************************************************************\n");
		}catch(Exception e){
			System.out.println("Lista de consultas do dia seguinte vazia");
		}
		
//		Gerando Relatório de Consultas do mes
//		String mes = JOptionPane.showInputDialog("Digite o número do mês a ser pesquisado");
		String mes = "04";
		consultas = ConsultaService.pesquisaConsultasDoMes(Integer.parseInt(mes));
		
		System.out.println("-------------------------------Consultas do mês "+mes+"-------------------------------");
		for (Consulta consulta : consultas) {
			System.out.println("idConsulta: "+ consulta.getId()+" - Nome do paciente: "+ consulta.getPaciente().getNome()+ " - Tel: "+ consulta.getPaciente().getTel()+" - Dr: "+consulta.getMedico().getNome());
		}
		
		System.out.println("******************************************************************************************\n");
		
//		Imprimindo Documentos Médicos de alguns pacientes
		DocumentoMedicoService.imprimeDocsPaciente((Paciente) BD.pesquisaPessoa(456123));
		DocumentoMedicoService.imprimeDocsPaciente((Paciente) BD.pesquisaPessoa(415452));
		
//		Pesquisando e imprimindo receita
		Receita receita = (Receita) dms.pesquisaDocMedico(1);
		System.out.println(dms.imprimirDocumento(receita));
		
		System.out.println("");
		
//		Pesquisando e imprimindo Atestado
		Atestado atestado = (Atestado) dms.pesquisaDocMedico(2);
		System.out.println(dms.imprimirDocumento(atestado));
		
//		Pesquisando e imprimindo Declaraçao de Acompanhamento
		DeclaracaoAcompanhamento declaracaoAcompanhamento = (DeclaracaoAcompanhamento) dms.pesquisaDocMedico(3);
		System.out.println(dms.imprimirDocumento(declaracaoAcompanhamento));
		
		
	}
}
