package persistencia;

import java.util.ArrayList;
import model.Consulta;
import model.DocumentoMedico;
import model.Funcionario;
import model.Medico;
import model.Paciente;
import model.Pessoa;
import model.Prontuario;
import model.Secretaria;

/*	Essa classe instancia um objeto que simula uma base de dados para a aplicação.
 *	Ela segue as especificações do padrão de projeto Singleton para garantir que esse objeto 
 *seja único e acessível de qualquer classe do programa.
 *
 *
 */

public final class BD {

//	Declaraçao dos Arrays que funcionam como tabelas
	private static BD bd;
	private static ArrayList<Paciente> pacientes;
	private static ArrayList<Medico> medicos;
	private static ArrayList<Secretaria> secretarias;
	private static ArrayList<Funcionario> funcionarios;
	private static ArrayList<Consulta> consultas;
	private static ArrayList<Prontuario> prontuarios;
	private static ArrayList<Pessoa> pessoas;
	private static ArrayList<DocumentoMedico> docsMedico;
//	id autoincrementáveis
	private static int idPessoa = 0;
	private static int idConsulta = 0;
	private static int idProntuario = 0;
	private static int idDocMed = 0;

	{
//		Inicializaçao das tabelas
		pacientes = new ArrayList<Paciente>();
		medicos = new ArrayList<Medico>();
		secretarias = new ArrayList<Secretaria>();
		consultas = new ArrayList<Consulta>();
		prontuarios = new ArrayList<Prontuario>();
		funcionarios = new ArrayList<Funcionario>();
		pessoas = new ArrayList<Pessoa>();
		docsMedico = new ArrayList<DocumentoMedico>();
	}
	
//	Cria conexao com o banco
	public static synchronized BD getConnection() {
		if (bd == null) {
			bd = new BD();
		}
		return bd;
	}
	
//	fecha conexao com o banco
	public static void closeConnection(){
		bd=null;
	}


//	Getters & Setters
	public static ArrayList<Paciente> getPacientes() {
		return pacientes;
	}


	public static ArrayList<DocumentoMedico> getDocsMedico() {
		return docsMedico;
	}


	public static void setDocsMedico(ArrayList<DocumentoMedico> docsMedic ) {
		docsMedico = docsMedic ;
	}


	public static ArrayList<Medico> getMedicos() {
		return medicos;
	}


	public static ArrayList<Secretaria> getSecretarias() {
		return secretarias;
	}


	public static ArrayList<Funcionario> getFuncionarios() {
		funcionarios.clear();
		funcionarios.addAll(medicos);
		funcionarios.addAll(secretarias);
		return funcionarios;
	}


	public static ArrayList<Consulta> getConsultas() {
		return consultas;
	}


	public static ArrayList<Prontuario> getProntuarios() {
		return prontuarios;
	}
	
	public static ArrayList<Pessoa> getPessoas() {
		pessoas.clear();
		pessoas.addAll(getFuncionarios());
		pessoas.addAll(pacientes);
		return pessoas;
	}


	public static int getIdPessoa() {
		return idPessoa;
	}


	public static void setIdPessoa(int idPessoa) {
		BD.idPessoa = idPessoa;
	}


	public static int getIdConsulta() {
		return idConsulta;
	}


	public static void setIdConsulta(int idConsulta) {
		BD.idConsulta = idConsulta;
	}


	public static int getIdProntuario() {
		return idProntuario;
	}


	public static void setIdProntuario(int idProntuario) {
		BD.idProntuario = idProntuario;
	}

	
//	Bloco de pesquisas-----------------------------------------------------------------
	
	public static ArrayList<DocumentoMedico> pesquisaDocMedicoPaciente(Paciente p){
		ArrayList<DocumentoMedico> docsDoPaciente = new ArrayList<DocumentoMedico>();
		for (DocumentoMedico dc : BD.getDocsMedico()) {
			if(dc.getPaciente().equals(p))
				docsDoPaciente.add(dc);
			}
		return docsDoPaciente;
	}
	
	public static DocumentoMedico pesquisaDocMedico(int id){
		for (DocumentoMedico dc : BD.getDocsMedico()) {
			if(dc.getId()==id)
				return (DocumentoMedico) dc;
		}
		return null;
	}
	
	public static Pessoa pesquisaPessoa(long cpf){
		for (Pessoa p : getPessoas()) {
			if (p.getCpf() == cpf) {
				return p;
			}
		}
		
		Pessoa p = new Pessoa();
		p.setNome("Pessoa não encontrada");
		return p;
	}
	
	public static Funcionario pesquisaFuncionario(String login){
		for (Funcionario f : getFuncionarios()) {
			if (f.getNome().equals(login)) {
				if(f instanceof model.Medico){
					Medico m = (Medico) f;
					return m;
				}else if( f instanceof model.Secretaria){
					Secretaria s = (Secretaria) f;
					return s;
				}
				//return f;
			}
		}
		
		Funcionario p = new Funcionario();
		p.setNome("Funcionario não encontrado");
		return p;
	}
	
	public static Medico pesquisaMedico(String login){
		for (Medico m : medicos) {
			if (m.getLogin().equals(login)) {
				return m;
			}
		}
		
		Medico p = new Medico();
		p.setNome("Médico não encontrado");
		return p;
	}
	
	public static Secretaria pesquisaSecretaria(String login){
		for (Secretaria s : secretarias) {
			if (s.getNome().equals(login)) {
				return s;
			}
		}

		Secretaria p = new Secretaria();
		p.setNome("Secretária não encontrada");
		return p;
	}
	
	public static Prontuario pesquisaProntuario(Paciente p){
		for (Prontuario pr : prontuarios) {
			if (pr.getPaciente().getCpf()==p.getCpf()) {
				return pr;
			}
		}
		
		Prontuario p1 = new Prontuario();
		p1.setPrescricao("Prontuario não encontrado");
		return p1;
	}
	
	public static ArrayList<Consulta> pesquisaConsultasMedico(Medico medico){
		ArrayList<Consulta> consultasDoMedico = new ArrayList<Consulta>();
		for (Consulta consulta : consultas) {
			if (consulta.getMedico()== medico) {
				consultasDoMedico.add(consulta);
			}
		}
		return consultasDoMedico;
	}
	
	public static Consulta pesquisaConsulta(Pessoa pessoa){
		for (Consulta consulta : consultas) {
			if (consulta.getPaciente().equals(pessoa)) {
				return consulta;
			}
		}
		return null;
	}
	
//	--------------------------------------------------------------------------
	

	
//	Bloco de adds-------------------------------------------------------------
	public static void addSecretaria(Secretaria s) {
		s.setId(++idPessoa);
		secretarias.add(s);	
	}
	
	public static void addMedico(Medico m) {
		m.setId(++idPessoa);
		medicos.add(m);	
	}
	
	public static void addPaciente(Paciente p) {
		p.setId(++idPessoa);
		pacientes.add(p);	
	}
	
	public static void addConsulta(Consulta c) {
		c.setId(++idPessoa);
		consultas.add(c);	
	}
	
	public static void addDocMedico(DocumentoMedico doc){
		doc.setId(++idDocMed);
		docsMedico.add(doc);
	}
	
	public static void addProntuario(Prontuario p){
		p.setId(++idProntuario);
		prontuarios.add(p);
	}
	
//	--------------------------------------------------------------------------
	
//	Bloco de removes-----------------------------------------------------------
	public static void removeSecretaria(Secretaria s) {
		secretarias.remove(s);	
	}
	public static void removeMedico(Medico m) {
		medicos.remove(m);	
	}
	public static void removePaciente(Paciente p) {
		pacientes.remove(p);	
	}
	public static void removeConsulta(Consulta c) {
		pacientes.remove(c);	
	}
	public static void removeDocMedico(DocumentoMedico doc){
		docsMedico.remove(doc);
	}
	public static void removeProntuario(Prontuario p){
		prontuarios.remove(p);
	}

//	--------------------------------------------------------------------------

/*  
 * 	Método de add usado antes da criaçao das classes Service
 
	public static void add(Object obj){
		if (obj instanceof model.Secretaria) {
			Secretaria s = (Secretaria)obj;
			s.setId(++idPessoa);
			secretarias.add(s);
		}else if (obj instanceof model.Paciente) {
			Paciente p = (Paciente)obj;
			p.setId(++idPessoa);
			pacientes.add(p);
		}else if( obj instanceof model.Medico) {
			Medico m = (Medico)obj;
			m.setId(++idPessoa);
			medicos.add(m);
		}else if (obj instanceof model.Prontuario) {	
			Prontuario pr = (Prontuario)obj;
			pr.setId(++idProntuario);
			prontuarios.add(pr);
		}else if (obj instanceof model.Consulta) {
			Consulta c = (Consulta)obj;
			c.setId(++idConsulta);
			consultas.add(c);
		}else if (obj instanceof model.Receita || obj instanceof model.Atestado || obj instanceof model.DeclaracaoAcompanhamento){
			DocumentoMedico doc = (DocumentoMedico)obj;
			doc.setId(++idDocMed);
			docsMedico.add(doc);
		}
	}
*/	
	
/*	
	 * Método Remove usado antes da criaçao das classes Service
	 * 
		public static void remove(Object obj){
			if (obj instanceof model.Secretaria) {
					secretarias.remove((Secretaria)obj);
			}else if (obj instanceof model.Paciente) {
				pacientes.remove((Paciente)obj);
			}else if (obj instanceof model.Medico) {
				medicos.remove((Medico)obj);
			}else if (obj instanceof model.Prontuario) {
				prontuarios.remove((Prontuario)obj);
			}else if (obj instanceof model.Consulta) {
				consultas.remove((Consulta)obj);
			}else if (obj instanceof model.Receita || obj instanceof model.Atestado || obj instanceof model.DeclaracaoAcompanhamento ) {
				docsMedico.remove((DocumentoMedico)obj);
			}		
		}
*/
	
	
}
