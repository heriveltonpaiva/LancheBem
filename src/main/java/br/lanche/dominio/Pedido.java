package br.lanche.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entidade responsável por armazenar as informações do
 * pedido realizado pelo cliente na lanchonete
 * @author Herivelton
 *
 */
@Entity
public class Pedido {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int numero;
	@OneToMany
	private List<OpcaoCardapio> opcoes;
	private double valorTotal;
	private Date dataCadastro;
	
	public Pedido() {
	   this.dataCadastro = new Date();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
