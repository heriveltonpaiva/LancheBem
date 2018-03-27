package br.lanche.negocio;

import java.util.HashMap;
import java.util.Map;

import br.lanche.dominio.Ingrediente;
import br.lanche.dominio.OpcaoCardapio;

/**
 * Builder Responsável por montar o cardápio
 * @author Herivelton
 *
 */
public class CardapioBuilder {

	public static void main (String[] args){
		imprimirConsoleLanches();
	}
	
	/** Método criado para impressão das opções do cardápio no console **/
	private static void imprimirConsoleLanches(){
		System.out.println("========================= CARDÁPIO DO LANCHE BEM  =========================");
		for (OpcaoCardapio opcao : montarLanches().values()) {
			System.out.println("OPÇÃO "+opcao.getId()+": "+opcao.getDescricao()+" R$: "+opcao.getValor());
			System.out.println("Ingredientes:");
			opcao.getIngredientes().stream().forEach(ingrediente -> System.out.println(""+ingrediente+","));
			System.out.println("_________________________________________________________________________");

		}
	}
	
	/**
	 * Método responsável por montar as opções disponível no 
	 * cardápio. 
	 * Optei por criar um mapa de ingredientes e adiciona-los
	 * na sua criação para reduzir o código e facilitar a leitura.
	 */
	public static Map<Integer,OpcaoCardapio> montarLanches(){
		Map<Integer, Ingrediente> mapa = montarIngredientes();
		Map<Integer, OpcaoCardapio> cardapio = new HashMap<>();
		
		Ingrediente hamburguer = mapa.get(Ingrediente.HAMBURGUER);
		Ingrediente bacon = mapa.get(Ingrediente.BACON);
		Ingrediente queijo = mapa.get(Ingrediente.QUEIJO);
		Ingrediente ovo = mapa.get(Ingrediente.OVO);
		
		int quantidade = 1;
		OpcaoCardapio xBacon = new OpcaoCardapio(1, "X-Bacon");
		
		OperacaoCardapio.adicionarIngrediente(bacon, quantidade, xBacon);
		OperacaoCardapio.adicionarIngrediente(hamburguer, quantidade, xBacon);
		OperacaoCardapio.adicionarIngrediente(queijo, quantidade, xBacon);
		
		OpcaoCardapio xBurguer =  new OpcaoCardapio(2, "X-Burger");
		
		OperacaoCardapio.adicionarIngrediente(queijo, quantidade, xBurguer);
		OperacaoCardapio.adicionarIngrediente(hamburguer, quantidade, xBurguer);
		
		OpcaoCardapio xEgg =  new OpcaoCardapio(3, "X-Egg");
		
		OperacaoCardapio.adicionarIngrediente(queijo, quantidade, xEgg);
		OperacaoCardapio.adicionarIngrediente(hamburguer, quantidade, xEgg);
		OperacaoCardapio.adicionarIngrediente(ovo, quantidade, xEgg);
		
		OpcaoCardapio xEggBacon =  new OpcaoCardapio(4, "X-Egg Bacon");
		
		OperacaoCardapio.adicionarIngrediente(queijo, quantidade, xEggBacon);
		OperacaoCardapio.adicionarIngrediente(hamburguer, quantidade, xEggBacon);
		OperacaoCardapio.adicionarIngrediente(ovo, quantidade, xEggBacon);
		OperacaoCardapio.adicionarIngrediente(bacon, quantidade, xEggBacon);
		
		cardapio.put(OpcaoCardapio.X_BACON, xBacon);
		
		cardapio.put(OpcaoCardapio.X_BURGUER, xBurguer);
		cardapio.put(OpcaoCardapio.X_EGG, xEgg);
		cardapio.put(OpcaoCardapio.X_EGG_BACON, xEggBacon); 
		
		return cardapio;
	}
	
	/** Monta o mapa de ingredientes disponíveis */
	public static Map<Integer,Ingrediente> montarIngredientes(){
	  Map<Integer,Ingrediente> lista = new HashMap<>();
	  
	  Ingrediente alface = new Ingrediente(1, "Alface", 0.40);
	  Ingrediente bacon = new Ingrediente(2, "Bacon", 2D);
	  Ingrediente hamburguer = new Ingrediente(3, "Hambúrguer", 3D);
	  Ingrediente ovo = new Ingrediente(4, "Ovo", 0.80);
	  Ingrediente queijo = new Ingrediente(5, "Queijo", 1.50);
	  
	  lista.put(Ingrediente.ALFACE, alface);
	  lista.put(Ingrediente.BACON, bacon);
	  lista.put(Ingrediente.HAMBURGUER, hamburguer);
	  lista.put(Ingrediente.OVO, ovo);
	  lista.put(Ingrediente.QUEIJO, queijo);
	  
	  return lista;
	}  
	
}
