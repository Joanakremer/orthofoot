package modelo;

import java.sql.Date;
import java.sql.Time;

public class MAgenda {
	private  int idConsulta;
	private String nome_Completo;
	private String contato;
	private Date data;
	private Time hora;
	private String titulo;
	
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public String getNome_Completo() {
		return nome_Completo;
	}
	public void setNome_Completo(String nome_Completo) {
		this.nome_Completo = nome_Completo;
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
