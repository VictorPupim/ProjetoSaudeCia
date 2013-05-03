package model;


import java.util.Calendar;

public class Paciente extends Pessoa {

	private TipoConvenio convenio;

	private String dadosAdicionais;

	private String alergias;

	private String cirurgias;

	private TipoConvenio tipoConvenio;

	
	
	public Paciente(String nome, String rg, long cpf, Calendar dataNasc,
			String endereco, String tel, String cel, String email, TipoConvenio tipoConvenio, 
			String dadosAdicionais, String alergias, String cirurgias) {
		super(nome, rg, cpf, dataNasc, endereco, tel, cel, email);
		this.tipoConvenio = tipoConvenio;
		this.dadosAdicionais = dadosAdicionais;
		this.alergias = alergias;
		this.cirurgias = cirurgias;		
	}

	public Paciente() {
		// TODO Auto-generated constructor stub
	}

	public TipoConvenio getConvenio() {
		return convenio;
	}

	public void setConvenio(TipoConvenio convenio) {
		this.convenio = convenio;
	}

	public String getDadosAdicionais() {
		return dadosAdicionais;
	}

	public void setDadosAdicionais(String dadosAdicionais) {
		this.dadosAdicionais = dadosAdicionais;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getCirurgias() {
		return cirurgias;
	}

	public void setCirurgias(String cirurgias) {
		this.cirurgias = cirurgias;
	}


	public TipoConvenio getTipoConvenio() {
		return tipoConvenio;
	}

	public void setTipoConvenio(TipoConvenio tipoConvenio) {
		this.tipoConvenio = tipoConvenio;
	}
	
	

}
