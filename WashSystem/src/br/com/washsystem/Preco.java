package br.com.washsystem;

import java.io.Serializable;

public class Preco implements Serializable {

	private int codigo;
	private Servico servico;
	private Roupa roupa;
	private double preco;
	
	public Preco(int codigo, Servico servico, Roupa roupa, double preco){
		
		this.codigo = codigo;
		this.servico = servico;
		this.roupa = roupa;
		this.preco = preco;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Roupa getRoupa() {
		return roupa;
	}

	public void setRoupa(Roupa roupa) {
		this.roupa = roupa;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
