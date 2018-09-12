package br.lanche.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entidade associativa que liga uma opção
 * de pedido a mais de um ingrediente extra
 * @author Herivelton
 *
 */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ingrediente == null) ? 0 : ingrediente.hashCode());
		result = prime * result + ((opcaoCardapio == null) ? 0 : opcaoCardapio.hashCode());
		result = prime * result + quantidade;
		long temp;
		temp = Double.doubleToLongBits(valorDesconto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpcaoIngrediente other = (OpcaoIngrediente) obj;
		if (id != other.id)
			return false;
		if (ingrediente == null) {
			if (other.ingrediente != null)
				return false;
		} else if (!ingrediente.equals(other.ingrediente))
			return false;
		if (opcaoCardapio == null) {
			if (other.opcaoCardapio != null)
				return false;
		} else if (!opcaoCardapio.equals(other.opcaoCardapio))
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (Double.doubleToLongBits(valorDesconto) != Double.doubleToLongBits(other.valorDesconto))
			return false;
		return true;
	}
	
	
}
