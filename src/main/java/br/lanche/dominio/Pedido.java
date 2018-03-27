package br.lanche.dominio;

import java.util.Date;
import java.util.List;

public class Pedido {
	
	private int numero;
	private List<OpcaoCardapio> opcoes;
	private double valorTotal;
	private Date dataCadastro;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public List<OpcaoCardapio> getOpcoes() {
		return opcoes;
	}
	public void setOpcoes(List<OpcaoCardapio> opcoes) {
		this.opcoes = opcoes;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	
}
