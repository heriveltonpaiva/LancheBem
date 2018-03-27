package br.lanche.negocio.promocao;

import br.lanche.dominio.OpcaoCardapio;

/**
 * Classe que implementa o cálculo para promoção Mais Queijo
 * @author Herivelton
 */
public class PromocaoCarne implements PromocaoStrategy{

	@Override
	public double calcularValorLanche(OpcaoCardapio opcao) {
		return 0;
	}
	
}
