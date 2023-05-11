package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class MPaciente {

	private int prontuario;
	private String nomeCompleto;
	private String contato;
	private String convenio;
	private int nCarteira;
	private String sexo;
	private LocalDate dataNasc;
	private Long cpf;
	private MEndereco endereco;
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate data) {
		this.dataNasc = data;
	}

	public MEndereco getEndereco() {
		return endereco;
	}

	public void setEndereco(MEndereco endereco) {
		this.endereco = endereco;
	}

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

	public int getnCarteira() {
		return nCarteira;
	}

	public void setnCarteira(int nCarteira) {
		this.nCarteira = nCarteira;
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

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public boolean isEmpty() {
		return false;
	}

}
