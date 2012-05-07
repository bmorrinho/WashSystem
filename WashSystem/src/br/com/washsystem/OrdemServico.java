package br.com.washsystem;

import java.io.Serializable;

public class OrdemServico implements Serializable{
	
	private int codigo;
	private Cliente cliente;
	private Servico servico; // como salvar uma lista de serviços e roupas?
	private Roupa roupa;

	public OrdemServico(int cod, Cliente cli, Servico serv, Roupa rou){
		
		this.codigo=cod;
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

}
