package br.lanche.negocio.promocao;

import br.lanche.dominio.Ingrediente;
import br.lanche.dominio.OpcaoCardapio;

/**
 * Classe que implementa o cálculo para promoção light
 * @author Herivelton
 */
public class PromocaoLight implements PromocaoStrategy{

	@Override
	public double calcularValorLanche(OpcaoCardapio opcao) {
		if(opcao.getIngredientes().contains(new Ingrediente(Ingrediente.BACON)))
			return opcao.getIngredientes().get(0).getValor();
		
		/** TODO 
		 * Implementar o contains para verificar se o ingrediente foi adicionado como extra
		 */
		//if(opcao.getIngredientesExtras().contains(new Ingrediente(Ingrediente.BACON)))
		
		double desconto = (opcao.getValor()* 0.10);
		double valorComDesconto = opcao.getValor() - desconto;
		return valorComDesconto;
	}
	
}
