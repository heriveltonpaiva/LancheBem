package br.lanche.negocio.promocao;

import br.lanche.dominio.OpcaoCardapio;
import br.lanche.dominio.OpcaoIngrediente;

/**
 * Classe que implementa o cálculo para promoção Mais Queijo
 * @author Herivelton
 */
public class PromocaoCarne implements PromocaoStrategy{

	@Override
	public double calcularValorLanche(OpcaoIngrediente opcao, OpcaoCardapio lanche) {
		double desconto = (opcao.getQuantidade() / 3) * 2;
		return opcao.getValorTotal() - desconto;
	}
	
}
