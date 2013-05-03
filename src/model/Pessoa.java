package model;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pessoa {

	private int id;

	private String nome;

	private String rg;

	private long cpf;

	private Calendar dataNasc;

	private String endereco;

	private String tel;

	private String cel;

	private String email;
	
	

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Construtor com passagem de parametros
	public Pessoa(String nome, String rg, long cpf, Calendar dataNasc,
			String endereco, String tel, String cel, String email) {
		
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
		this.tel = tel;
		this.cel = cel;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNasc(){
		return dataNasc;
	}
	
	public String getDataNascStr() {
		Date nasc = dataNasc.getTime();
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		return df.format(nasc);
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

		

}
