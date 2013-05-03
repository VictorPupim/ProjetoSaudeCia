package model;




import java.util.Calendar;




public class Consulta {

	private int id;

	private Paciente paciente;
	
	private Medico medico;

	private Calendar data;

	private Calendar horario;

	private tipoConsulta tipoConsulta;
	

	public Consulta(Paciente paciente, Medico medico, Calendar data,
			Calendar horario, model.tipoConsulta tipoConsulta) {
		super();
		this.paciente = paciente;
		this.medico = medico;
		this.data = data;
		this.horario = horario;
		this.tipoConsulta = tipoConsulta;
	}

	public Consulta() {
		// TODO Auto-generated constructor stub
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

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public StringBuilder getHorario() {
		StringBuilder horaConsulta = new StringBuilder("");
		
	    horaConsulta.append(horario.get(Calendar.HOUR_OF_DAY));
		horaConsulta.append(":");
		horaConsulta.append(horario.get(Calendar.MINUTE));
		return horaConsulta;
	}

	public void setHorario(Calendar horario) {
		this.horario = horario;
	}

	public tipoConsulta getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(tipoConsulta tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

}
