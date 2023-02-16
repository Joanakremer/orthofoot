package modelo;

import java.sql.Date;

public class MPaciente {
	
	private int prontuario;
	private String nome_completo;
	private String contato;
	private String convenio;
	private String n_carteira;
	private String sexo;
	private Date data_nasc;
	
	
	
	public int getProntuario() {
		return prontuario;
	}



	public void setProntuario(int prontuario) {
		this.prontuario = prontuario;
	}



	public String getNome_completo() {
		return nome_completo;
	}



	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
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



	public String getN_carteira() {
		return n_carteira;
	}



	public void setN_carteira(String n_carteira) {
		this.n_carteira = n_carteira;
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



	public long getCpf() {
		return cpf;
	}



	public void setCpf(long cpf) {
		this.cpf = cpf;
	}



	private long cpf;
	
}
