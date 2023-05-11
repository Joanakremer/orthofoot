package modelo;

import java.sql.Date;
import java.sql.Time;

public class MAgenda {
	private  int idConsulta;
	private String nomeCompleto;
	private String contato;
	private Date data;
	private Time hora;
	private String titulo;
	private MMedico medico;
	private MPaciente paciente;
	
	public MMedico getMedico() {
		return medico;
	}
	public void setMedico(MMedico medico) {
		this.medico = medico;
	}
	public MPaciente getPaciente() {
		return paciente;
	}
	public void setPaciente(MPaciente paciente) {
		this.paciente = paciente;
	}
	
	
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
