package br.com.washsystem;

import java.io.Serializable;

public class Cliente implements Serializable {
	
	private int codigo;
	private String nome;
	private String sobrenome;
	private String endereco;
	private int num_endereco;
	private String cidade;
	private String estado;
	private String cep;
	private String telefone;
	private boolean pendencia;
	
	public Cliente(int codigo,
				   String nome,
				   String sobrenome,
				   String endereco,
				   int num_endereco,
				   String cidade,
				   String estado,
				   String cep,
				   String telefone){
				
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.setEndereco(endereco);
		this.setNum_endereco(num_endereco);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setCep(cep);
		this.setTelefone(telefone);
		
		this.setPendencia(false);
		
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNum_endereco() {
		return num_endereco;
	}

	public void setNum_endereco(int num_endereco) {
		this.num_endereco = num_endereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean hasPendencia() {
		return pendencia;
	}

	public void setPendencia(boolean pendencia) {
		this.pendencia = pendencia;
	}

}
