package model;

import java.util.Calendar;

public class Receita extends DocumentoMedico {

	public Receita(Paciente paciente, Medico medico, String prescricao, Calendar data) {
		super(paciente, medico, prescricao, data);
	}	
}
