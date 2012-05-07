package br.com.washsystem;

import java.io.Serializable;

public class Servico implements Serializable{
	
	private int codigo;
	private String descricao;
	
	public Servico(int codigo, String descricao){
		
		this.codigo = codigo;
		this.descricao = descricao;
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
