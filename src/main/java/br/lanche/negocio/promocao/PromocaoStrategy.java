package br.lanche.negocio.promocao;

import br.lanche.dominio.OpcaoCardapio;
import br.lanche.dominio.OpcaoIngrediente;

/**
 * Interface do Designer Pattern Strategy
 * @author Herivelton
 *
 */
public interface PromocaoStrategy {
	public double calcularValorLanche(OpcaoIngrediente opcao, OpcaoCardapio lanche);
}
