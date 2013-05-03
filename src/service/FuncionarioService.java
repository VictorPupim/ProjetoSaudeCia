package service;

import persistencia.BD;
import model.Funcionario;
import model.Medico;
import model.Secretaria;

public class FuncionarioService {
	{
		BD.getConnection();
	}

	public void add(Funcionario f) {
		if (f instanceof model.Secretaria) {
			Secretaria s = (Secretaria)f;
			BD.addSecretaria(s);
		}else if( f instanceof model.Medico) {
			Medico m = (Medico)f;
			BD.addMedico(m);	
		}	
	}

	
	public void remove(Funcionario f) {
		if (f instanceof model.Secretaria) {
			Secretaria s = (Secretaria)f;
			BD.removeSecretaria(s);
		}else if( f instanceof model.Medico) {
			Medico m = (Medico)f;
			BD.removeMedico(m);	
		}
	}

	
	public Funcionario pesquisa(String login) {
		return BD.pesquisaFuncionario(login);
	}

	
	
	
}
