package br.lanche.negocio.promocao;

import br.lanche.dominio.OpcaoCardapio;

/**
 * Classe que implementa o cálculo para promoção light
 * @author Herivelton
 */
public class PromocaoQueijo implements PromocaoStrategy{

	@Override
	public double calcularValorLanche(OpcaoCardapio opcao) {
		return 0;
	}
	
}
