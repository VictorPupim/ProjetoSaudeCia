package model;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import persistencia.BD;

public abstract class DocumentoMedico {
	private int id;
	private Paciente paciente;
	private Medico medico;
	private String texto;
	private Calendar data;
	
	public DocumentoMedico(Paciente paciente, Medico medico,
			String texto, Calendar data) {
		super();
		this.paciente = paciente;
		this.medico = medico;
		this.texto = texto;
		this.data = data;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	

	public String getDataStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data.getTime());
	}
	
	
}
