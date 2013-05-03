package model;

import java.util.Calendar;

public class Funcionario extends Pessoa {

	public Funcionario() {
		super();
	}
	
	//construtor com passagem de parametros
	public Funcionario(String nome, String rg, long cpf,
			Calendar dataNasc, String endereco, String tel, String cel,
			String email, String login, String senha, int acesso) {
		super(nome, rg, cpf, dataNasc, endereco, tel, cel, email);
		this.login = login;
		this.senha = senha;
		this.acesso = acesso;
	}


	private String login;

	private String senha;

	private int acesso;
	
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getAcesso() {
		return acesso;
	}

	public void setAcesso(int acesso) {
		this.acesso = acesso;
	}
	
	
}
