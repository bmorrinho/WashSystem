package br.com.washsystem;

import java.io.Serializable;

public class OrdemServico implements Serializable{
	
	private int codigo;
	private int sequencia;
	private Cliente cliente;
	private Servico servico; // como salvar uma lista de servi�os e roupas?
	private Roupa roupa;

	public OrdemServico(int cod, int sequencia, Cliente cli, Servico serv, Roupa rou){
		
		this.codigo=cod;
		this.sequencia=sequencia;
		this.cliente=cli;
		this.servico=serv;
		this.roupa=rou;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public int getSequencia() {
		return sequencia;
	}

	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}

}
