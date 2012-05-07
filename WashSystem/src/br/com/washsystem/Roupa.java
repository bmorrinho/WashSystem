package br.com.washsystem;

import java.io.Serializable;

public class Roupa implements Serializable {
	
	private int codigo;
	private String tipo;
	private String tecido;
	
	public Roupa(int codigo, String tipo, String tecido){
		
		this.codigo = codigo;
		this.tipo = tipo;
		this.tecido = tecido;
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTecido() {
		return tecido;
	}
	public void setTecido(String tecido) {
		this.tecido = tecido;
	}
	
	

}
