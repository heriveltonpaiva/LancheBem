package br.lanche.negocio;

import br.lanche.dominio.Ingrediente;
import br.lanche.dominio.OpcaoCardapio;

/**
 * Interface utilizada para adição de ingredientes extra
 * as opções do cardapio
 * @author Herivelton Paiva
 */
public interface LancheCardapio {
	
	public OpcaoCardapio addIngrediente(Ingrediente ingrediente);
	
	
}
