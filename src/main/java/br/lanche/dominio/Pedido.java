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
	private double valorTotal;
	private Date dataCadastro;
	@ManyToOne
	private OpcaoIngrediente opcaoIngrediente;
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
	
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public OpcaoIngrediente getOpcaoIngrediente() {
		return opcaoIngrediente;
	}
	public void setOpcaoIngrediente(OpcaoIngrediente opcaoIngrediente) {
		this.opcaoIngrediente = opcaoIngrediente;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	
}
