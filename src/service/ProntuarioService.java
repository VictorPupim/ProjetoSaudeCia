package service;


import model.Paciente;
import model.Prontuario;
import persistencia.BD;

public class ProntuarioService {
	{
		BD.getConnection();
	}
	
	public void add(Prontuario p){
		BD.addProntuario(p);
	}
	
	public void remove(Prontuario p){
		BD.removeProntuario(p);
	}
	
	public Prontuario pesquisa(Paciente p){
		return BD.pesquisaProntuario(p);
	}
	
}
