package br.lanche.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.util.CollectionUtils;

import br.lanche.negocio.LancheCardapio;

/**
 * Entidade que representa a opção do cardápio
 * com a composição dos seus ingredientes
 * @author Herivelton
 */
public class OpcaoCardapio implements LancheCardapio{
	
	private int id; 
	private String descricao;
	/** Ingredientes base para composição **/
	private List<Ingrediente> ingredientes;
	/** valor unitário da opção **/
	private double valor; 
	
	private List<OpcaoIngrediente> ingredientesExtras;
	
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
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
  
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getValor() {
		return valor;
	}
	
	public List<OpcaoIngrediente> getIngredientesExtras() {
		return ingredientesExtras;
	}
	public void setIngredientesExtras(List<OpcaoIngrediente> ingredientesExtras) {
		this.ingredientesExtras = ingredientesExtras;
	}
	
	@Override
	public OpcaoCardapio addIngrediente(Ingrediente ingrediente) {
		if(this.ingredientes == null)
			ingredientes = new ArrayList<>();
		this.ingredientes.add(ingrediente);
		return this;
	}
	
	@Override
	public String toString() {
		return id+" - "+descricao+" R$: "+getValor();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		return true;
	}
	
}
