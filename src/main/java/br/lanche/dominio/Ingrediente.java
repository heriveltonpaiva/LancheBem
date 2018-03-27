package br.lanche.dominio;

/**
 * Entidade responsável por armazenar os 
 * ingredientes das opções do cardápio e os seus respectivos valores  
 * @author Herivelton 
 */
public class Ingrediente {

	/** Constantes para auxiliar na leitura do código, também
	 * haveria a possibilidade de criar enums **/
	public final static int ALFACE = 1;
	public final static int BACON = 2;
	public final static int HAMBURGUER = 3;
	public final static int OVO = 4;
	public final static int QUEIJO = 5;
	
	private int id;
	private String descricao;
    private double valor;
    
    public Ingrediente() {
	}
    
    public Ingrediente(int id, String descricao, double valor){
       this.id = id;
       this.descricao = descricao;
       this.valor = valor;
    }
    
	public Ingrediente(int id) {
		this.id = id;
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return id+" - "+descricao+" - R$:"+valor;
	}
	
}
