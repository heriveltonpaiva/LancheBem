package br.lanche.negocio.promocao;

import br.lanche.dominio.OpcaoCardapio;

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
	
	public double getPrecoComDesconto(OpcaoCardapio opcao){
		return strategy.calcularValorLanche(opcao);
	}
	
	/**
	 * Optei por implementar esse padrão de projeto, para isolar a responsabilidade
	 * de promoção e permite a facil expansão, caso deseje adicionar novas promoções,
	 * e dessa forma facilmente alteramos a promoção apenas no método concreto da classe.
	 */
}
