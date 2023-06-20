package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MMedico {
	private long crm;
	private String nomeCompleto;
	private String sexo;
	private LocalDate dataNasc;
	public long getCrm() {
		return crm;
	}
	public void setCrm(long crm) {
		this.crm = crm;
	}
	public String getnomeCompleto() {
		return nomeCompleto;
	}
	public void setnomeCompleto(String nomeCompleto) {
		this.nomeCompleto= nomeCompleto;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public LocalDate getdataNasc() {
		return dataNasc;
	}
	public String getDataFormatada() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = dataNasc.format(dateTimeFormatter);  //17-02-2022
		return formattedDate;
	}
	public void setdataNasc(LocalDate data) {
		this.dataNasc = data;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nomeCompleto;
	}
}
