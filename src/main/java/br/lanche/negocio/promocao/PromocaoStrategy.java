package br.lanche.negocio.promocao;

import br.lanche.dominio.OpcaoCardapio;

/**
 * Interface do Designer Pattern Strategy
 * @author Herivelton
 *
 */
public interface PromocaoStrategy {
	public double calcularValorLanche(OpcaoCardapio opcao);
}
