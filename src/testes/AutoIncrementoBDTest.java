package testes;

import static org.junit.Assert.*;

import model.Consulta;
import model.Medico;
import model.Paciente;
import model.Secretaria;

import org.junit.Before;
import org.junit.Test;

import service.ConsultaService;
import service.FuncionarioService;
import service.PacienteService;

public class AutoIncrementoBDTest {
	Medico m1;
	Secretaria s1;
	Paciente p1;
	Consulta c1;
	Consulta c2;
	Consulta c3;
	FuncionarioService fs;
	PacienteService ps;
	ConsultaService cs;
	
	@Before
	public void setUp() throws Exception {
		m1 = new Medico();
		m1.setLogin("login");
		s1 = new Secretaria();
		s1.setLogin("loginSec");
		p1 = new Paciente();
		p1.setCpf(123456);
		c1 = new Consulta();
		c1.setPaciente(p1);
		c2 = new Consulta();
		c2.setPaciente(p1);
		c3 = new Consulta();
		c3.setPaciente(p1);
		fs = new FuncionarioService();
		ps = new PacienteService();
		cs = new ConsultaService();
	}

	@Test
	public void test() {
		fs.add(m1);
		fs.add(s1);
		int expect = 2;
		assertTrue(fs.pesquisa("loginSec").getId()==expect);
	}
	
	@Test
	public void test2() {
		ps.add(p1);
		int expect = 1;
		assertTrue(ps.pesquisa(123456).getId()==expect);
	}
	
	@Test
	public void test3() {
		cs.add(c1);
		int expect = 1;
		assertTrue(cs.pesquisa(p1).getId()==expect);
	}

}
