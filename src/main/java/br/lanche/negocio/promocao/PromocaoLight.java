package br.lanche.negocio.promocao;

import br.lanche.dominio.OpcaoCardapio;
import br.lanche.dominio.OpcaoIngrediente;

/**
 * Classe que implementa o cálculo para promoção light
 * @author Herivelton
 */
public class PromocaoLight implements PromocaoStrategy{

	@Override
	public double calcularValorLanche(OpcaoIngrediente opcao, OpcaoCardapio lanche) {
		double desconto = (lanche.getValorOriginal() * 0.10);
		double valorComDesconto = lanche.getValor() - desconto;
		return valorComDesconto;
	}
	
}
