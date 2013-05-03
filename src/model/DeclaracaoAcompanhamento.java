package model;

import java.util.Calendar;

public class DeclaracaoAcompanhamento extends DocumentoMedico{
	private Pessoa acompanhante;

	
	
	public DeclaracaoAcompanhamento(Paciente paciente, Pessoa acompanhante, Medico medico,
			String obs, Calendar data) {
		super(paciente, medico, obs, data);
		this.acompanhante = acompanhante;
	}

	public Pessoa getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(Pessoa acompanhante) {
		this.acompanhante = acompanhante;
	}

	

	
}
