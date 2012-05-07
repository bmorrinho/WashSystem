package br.com.washsystem;

import java.io.Serializable;

public class Servico implements Serializable{
	
	private int codigo;
	private String descricao;
	private double preco;
	
	public Servico(int codigo, String descricao, double preco){
		
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
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
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
