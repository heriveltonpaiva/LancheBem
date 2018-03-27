package br.lanche.dominio;

/**
 * Entidade associativa que liga uma opção
 * de pedido a mais de um ingrediente extra
 * @author Herivelton
 *
 */
public class OpcaoIngrediente {

	private OpcaoCardapio opcaoCardapio;
	private Ingrediente ingrediente;
	private int quantidade;
	
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
	
}
