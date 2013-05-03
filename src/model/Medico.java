package model;

import java.util.Calendar;

public class Medico extends Funcionario {

	private String especialidade;

	private String crm;
	

	public Medico() {
		super();
	}
	
	public Medico(String nome, String rg, long cpf, Calendar dataNasc,
			String endereco, String tel, String cel, String email,
			String login, String senha, int acesso, String especialidade, String crm) {
		super(nome, rg, cpf, dataNasc, endereco, tel, cel, email, login, senha,
				acesso);
		this.especialidade = especialidade;
		this.crm= crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

		
	
}
