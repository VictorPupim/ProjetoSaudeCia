package model;

import java.util.Calendar;

public class Atestado extends DocumentoMedico {
	private int qtdDias;
	
	public Atestado(Paciente paciente, Medico medico, String doen�a, Calendar data, int qtdDias) {
		super(paciente, medico, doen�a, data);
		// TODO Auto-generated constructor stub
		this.qtdDias = qtdDias;
	}

	public int getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}

	
		
	
	
}
