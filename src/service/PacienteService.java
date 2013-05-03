package service;

import model.Paciente;
import persistencia.BD;

public class PacienteService {
	{
		BD.getConnection();
	}
	
	public void add(Paciente p){
		BD.addPaciente(p);
	}
	
	public void remove(Paciente p){
		BD.removePaciente(p);
	}
	
	public Paciente pesquisa(long cpf){
		return (Paciente) BD.pesquisaPessoa(cpf);
	}
	
	
}
