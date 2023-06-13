package modelo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class MAgenda {
	private  int idConsulta;
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
	

	public String getDataFormatada() {
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(data);
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
