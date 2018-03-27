package br.lanche.negocio.promocao;

import br.lanche.dominio.OpcaoCardapio;
import br.lanche.dominio.OpcaoIngrediente;

/**
 * Implementação da classe de contexto do
 * padrão Strategy
 * @author Herivelton Paiva
 */
public class Promocao {

	private PromocaoStrategy strategy;
	
	public Promocao(PromocaoStrategy strategy) {
		this.strategy = strategy;
	}
	
	public double getPrecoComDesconto(OpcaoIngrediente opcaoIngrediente, OpcaoCardapio lanche){
		return strategy.calcularValorLanche(opcaoIngrediente, lanche);
	}
	
	/**
	 * Optei por implementar esse padrão de projeto, para isolar a responsabilidade
	 * de promoção e permite a facil expansão, caso deseje adicionar novas promoções,
	 * e dessa forma facilmente alteramos a promoção apenas no método concreto da classe.
	 */
}
