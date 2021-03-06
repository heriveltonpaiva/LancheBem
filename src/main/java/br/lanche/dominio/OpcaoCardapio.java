package br.lanche.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * Entidade que representa a opção do cardápio
 * com a composição dos seus ingredientes
 * @author Herivelton
 */
@Entity
public class OpcaoCardapio{
	
	/** Constantes para auxiliar na leitura do código **/
	public final static int X_BACON = 1;
	public final static int X_BURGUER = 2;
	public final static int X_EGG = 3;
	public final static int X_EGG_BACON = 4;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private String descricao;
	/** Valor final considerando as promoções **/
	private double valor; 
	/** Variável criada para guardar o valor original sem desconto **/
	private double valorOriginal;
	@Transient
	private List<OpcaoIngrediente> ingredientes;
	
	public OpcaoCardapio() {
		ingredientes = new ArrayList<>();
	}
	
	public OpcaoCardapio(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<OpcaoIngrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<OpcaoIngrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public double getValorOriginal() {
		return valorOriginal;
	}
	public void setValorOriginal(double valorOriginal) {
		this.valorOriginal = valorOriginal;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return id+" - "+descricao+" R$: "+getValor();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		result = prime * result + ((ingredientes == null) ? 0 : ingredientes.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorOriginal);
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
		OpcaoCardapio other = (OpcaoCardapio) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (ingredientes == null) {
			if (other.ingredientes != null)
				return false;
		} else if (!ingredientes.equals(other.ingredientes))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		if (Double.doubleToLongBits(valorOriginal) != Double.doubleToLongBits(other.valorOriginal))
			return false;
		return true;
	}
    
	
	
}
