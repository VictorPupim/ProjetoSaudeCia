package model;

import java.util.Calendar;

public class Secretaria extends Funcionario {

	//Construtor com parametros
	public Secretaria(String nome, String rg, long cpf,
			Calendar dataNasc, String endereco, String tel, String cel,
			String email, String login, String senha, int acesso) {
		super(nome, rg, cpf, dataNasc, endereco, tel, cel, email, login, senha,
				acesso);
	}

	public Secretaria() {
		super();
	}
	
	
	
	
}
