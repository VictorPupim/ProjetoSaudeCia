package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import model.Consulta;
import model.Pessoa;
import persistencia.BD;

public class ConsultaService {
	{
		BD.getConnection();
	}
	
	public void add(Consulta c){
		BD.addConsulta(c);
	}
	
	public void remove(Consulta c){
		BD.removeConsulta(c);
	}
	
	public Consulta pesquisa(Pessoa p){
		return BD.pesquisaConsulta(p);
	}
	
	public static ArrayList<Consulta> pesquisaConsultasDoMes(int mes) {
		ArrayList<Consulta> consultasMes = new ArrayList<Consulta>();
		
		for (Consulta consulta : BD.getConsultas()) {
			//System.out.println(consulta.getData().get(Calendar.MONTH));
			if (consulta.getData().get(Calendar.MONTH) == (mes-1)) {
				consultasMes.add(consulta);
			}
		}
		
		return consultasMes;

	}
	public static ArrayList<Consulta> pesquisaConsultasDia(int dia) {
		ArrayList<Consulta> consultasDia = new ArrayList<Consulta>();
		
		for (Consulta consulta : BD.getConsultas()) {
			//System.out.println(consulta.getData().get(Calendar.DAY_OF_MONTH));
			if (consulta.getData().get(Calendar.DAY_OF_MONTH) == dia) {
				consultasDia.add(consulta);
			}
		}
		
		return consultasDia;
	}
	
	public static ArrayList<Consulta> pesquisaConsultasDiaSeguinte(){
		ArrayList<Consulta> consultasDiaSeguinte = new ArrayList<Consulta>();
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		
		c.add(Calendar.DAY_OF_MONTH, 1);
		
		consultasDiaSeguinte = pesquisaConsultasDia(c.get(Calendar.DAY_OF_MONTH));
		
		for (Consulta consulta : consultasDiaSeguinte) {
			if (consulta.getPaciente().getEmail()!="" && consulta.getPaciente().getCel()!="") {
				consultasDiaSeguinte.remove(consulta);
			}
		}
		return consultasDiaSeguinte;
	}
	
}
	
