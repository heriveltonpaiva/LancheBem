package br.lanche.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.lanche.dominio.Ingrediente;
import br.lanche.dominio.OpcaoCardapio;

public class CardapioBuilder {

	public static void main (String[] args){
		imprimirConsoleLanches();
	}
	
	/**
	 * Método responsável por montar as opções disponível no 
	 * cardápio. 
	 * Optei por criar um mapa de ingredientes e adiciona-los
	 * na sua criação para reduzir o código e facilitar a leitura.
	 */
	public static List<LancheCardapio> montarLanches(){
		Map<Integer, Ingrediente> mapa = montarIngredientes();
		List<LancheCardapio> lista = new ArrayList<>();
		
		lista.add(new OpcaoCardapio(1, "X-Bacon")
				.addIngrediente(mapa.get(Ingrediente.BACON))
				.addIngrediente(mapa.get(Ingrediente.HAMBURGUER))
				.addIngrediente(mapa.get(Ingrediente.QUEIJO)));
		
		lista.add(new OpcaoCardapio(2, "X-Burger")
				.addIngrediente(mapa.get(Ingrediente.HAMBURGUER))
				.addIngrediente(mapa.get(Ingrediente.QUEIJO)));
		
		lista.add(new OpcaoCardapio(3, "X-Egg")
				.addIngrediente(mapa.get(Ingrediente.OVO))
				.addIngrediente(mapa.get(Ingrediente.HAMBURGUER))
				.addIngrediente(mapa.get(Ingrediente.QUEIJO)));
		
		lista.add(new OpcaoCardapio(4, "X-Egg Bacon")
				.addIngrediente(mapa.get(Ingrediente.OVO))
				.addIngrediente(mapa.get(Ingrediente.BACON))
				.addIngrediente(mapa.get(Ingrediente.HAMBURGUER))
				.addIngrediente(mapa.get(Ingrediente.QUEIJO)));
		
		return lista;
	}
	
	/** Método criado para impressão das opções do cardápio no console **/
	private static void imprimirConsoleLanches(){
		montarLanches().stream().forEach(opcaoCardapio -> System.out.println(opcaoCardapio));
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
