package br.lanche.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Entidade associativa que liga uma opção
 * de pedido a mais de um ingrediente extra
 * @author Herivelton
 *
 */
//Anotação utilizada para resolver o problema de lista circular
@JsonIgnoreProperties({ "opcaoCardapio"})
@Entity
public class OpcaoIngrediente {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private OpcaoCardapio opcaoCardapio;
	@ManyToOne
	private Ingrediente ingrediente;
	private int quantidade;
	private double valorDesconto;
	public OpcaoIngrediente() {
	}
	
	public OpcaoIngrediente(OpcaoCardapio opcao, Ingrediente ingrediente, int qnt) {
		this.opcaoCardapio = opcao;
		this.ingrediente = ingrediente;
		this.quantidade = qnt;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public OpcaoCardapio getOpcaoCardapio() {
		return opcaoCardapio;
	}
	public void setOpcaoCardapio(OpcaoCardapio opcaoCardapio) {
		this.opcaoCardapio = opcaoCardapio;
	}
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	public double getValorDesconto() {
		return valorDesconto;
	}
	public double getValorTotal() {
		return ingrediente.getValor() * quantidade;
	}
	
	@Override
	public String toString() {
		return quantidade+" "+getIngrediente().getDescricao()+" R$: "+getValorTotal();
	}
}
