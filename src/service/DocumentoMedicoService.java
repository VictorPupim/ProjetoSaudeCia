package service;

import java.util.ArrayList;

import model.Atestado;
import model.DeclaracaoAcompanhamento;
import model.DocumentoMedico;
import model.Paciente;
import model.Pessoa;
import persistencia.BD;

public class DocumentoMedicoService {
	{
		BD.getConnection();
	}
	public void add(DocumentoMedico doc){
		BD.addDocMedico(doc);
	}
	public void remove(DocumentoMedico doc){
		BD.removeDocMedico(doc);
	}
	public DocumentoMedico pesquisaDocMedico(int id){
		return BD.pesquisaDocMedico(id);
	}
	public ArrayList<DocumentoMedico> pesquisaDocsMedico(Pessoa p){
		return pesquisaDocsMedico(p);
	}
	
	public static void imprimeDocsPaciente(Paciente p){
		ArrayList<DocumentoMedico> docsPaciente = BD.pesquisaDocMedicoPaciente(p);
		int tam;
		System.out.println("---------------------Documentos Médicos do Paciente "+p.getNome()+"-----------------------");
		for (DocumentoMedico documentoMedico : docsPaciente) {
			tam = documentoMedico.getClass().getName().length();
			System.out.println("id: "+documentoMedico.getId()+"     Tipo: "+documentoMedico.getClass().getName().subSequence(6, tam)+"    Data: "+documentoMedico.getDataStr());
		}
		System.out.println("******************************************************************************************\n");
	}
	
	public StringBuilder imprimirDocumento(DocumentoMedico doc) {
		if(doc instanceof model.Receita){
			StringBuilder receita = new StringBuilder("");
			receita.append("-------------------------Receita Médica-----------------------\n\n");
			receita.append("Paciente: "+doc.getPaciente().getNome()+"     CPF: "+doc.getPaciente().getCpf()+"\n\n");
			receita.append("Prescrição: \n\n");
			receita.append(doc.getTexto()+"\n\n");
			receita.append("Data: "+doc.getDataStr());
			receita.append("\n\n\n\n\n");
			receita.append("Dr. "+doc.getMedico().getNome()+"\n");
			receita.append("CRM: "+doc.getMedico().getCrm()+"\n");
			receita.append("*****************************************************************************************\n");
			return receita;
		}
		else if (doc instanceof model.Atestado) {
			Atestado at = (Atestado)doc;
			StringBuilder atestado = new StringBuilder("");
			atestado.append("-------------------------Atestado Médico-----------------------\n\n");
			atestado.append("Atesto que "+at.getPaciente().getNome()+" esteve imposibilitado de realizar suas atividades\npor questôes de saúde pelo período de "+at.getQtdDias()+" dias.\n\n");
			atestado.append("Motivo: "+at.getTexto()+"\n\n");
			atestado.append("\n\n\n\n\n");
			atestado.append("Dr. "+at.getMedico().getNome()+"\n");
			atestado.append("CRM: "+at.getMedico().getCrm()+"\n");
			atestado.append("*****************************************************************************************\n");
			return atestado;
		}
		else if (doc instanceof model.DeclaracaoAcompanhamento) {
			DeclaracaoAcompanhamento da = (DeclaracaoAcompanhamento)doc;
			StringBuilder declaracao = new StringBuilder("");
			declaracao.append("-------------------------Declaração de Acomopanhamento-----------------------\n\n");
			declaracao.append("Declaro que "+da.getAcompanhante().getNome()+" esteve acompanhado "+da.getPaciente().getNome()+" em consulta médica no dia "+da.getDataStr()+"\n");
			declaracao.append("Obs: "+da.getTexto()+"\n\n");
			declaracao.append("\n\n\n\n\n");
			declaracao.append("Dr. "+da.getMedico().getNome()+"\n");
			declaracao.append("CRM: "+da.getMedico().getCrm()+"\n");
			declaracao.append("*****************************************************************************************\n");
			return declaracao;
		}
		else{
			StringBuilder naoEcontrado = new StringBuilder("Documento não encontrado");
			return naoEcontrado;
	}
	}
}
