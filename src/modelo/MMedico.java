package modelo;

import java.sql.Date;

public class MMedico {
	private long crm;
	private String nome_completo;
	private String sexo;
	private Date data_nasc;
	
	public long getCrm() {
		return crm;
	}
	public void setCrm(long crm) {
		this.crm = crm;
	}
	public String getNome_completo() {
		return nome_completo;
	}
	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}
}
