package br.lanche.dominio;

import java.util.Date;
import java.util.List;

/**
 * Entidade responsável por armazenar as informações do
 * pedido realizado pelo cliente na lanchonete
 * @author Herivelton
 *
 */
public class Pedido {
	
	private int numero;
	private List<OpcaoCardapio> opcoes;
	private double valorTotal;
	private Date dataCadastro;
	
	public Pedido() {
	   this.dataCadastro = new Date();
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
