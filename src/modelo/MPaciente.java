package modelo;

import java.sql.Date;

public class MPaciente {
	
	private int prontuario;
	private String nomeCompleto;
	private String contato;
	private String convenio;
	private String nCarteira;
	private String sexo;
	private Date dataNasc;
	
	
	
	public int getProntuario() {
		return prontuario;
	}



	public void setProntuario(int prontuario) {
		this.prontuario = prontuario;
	}



	public String getnomeCompleto() {
		return nomeCompleto;
	}



	public void setnomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}



	public String getContato() {
		return contato;
	}



	public void setContato(String contato) {
		this.contato = contato;
	}



	public String getConvenio() {
		return convenio;
	}



	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}



	public String getnCarteira() {
		return nCarteira;
	}



	public void setnCarteira(String nCarteira) {
		this.nCarteira = nCarteira;
	}



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public Date getdataNasc() {
		return dataNasc;
	}



	public void setdataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}



	public long getCpf() {
		return cpf;
	}



	public void setCpf(long cpf) {
		this.cpf = cpf;
	}



	private long cpf;
	
}
