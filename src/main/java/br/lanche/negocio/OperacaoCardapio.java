package br.lanche.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import br.lanche.dominio.Ingrediente;
import br.lanche.dominio.OpcaoCardapio;
import br.lanche.dominio.OpcaoIngrediente;
import br.lanche.dominio.Pedido;
import br.lanche.negocio.promocao.Promocao;
import br.lanche.negocio.promocao.PromocaoCarne;
import br.lanche.negocio.promocao.PromocaoLight;
import br.lanche.negocio.promocao.PromocaoQueijo;

/**
 * Classe que realiza as operações dos lanches
 * @author Herivelton
 * 
 */
public class OperacaoCardapio {

	public static void main (String args[]){
		List<LancheCardapio> lanches = CardapioBuilder.montarLanches();
		Map<Integer, Ingrediente> ingredientes = CardapioBuilder.montarIngredientes();
		OpcaoCardapio opcao = (OpcaoCardapio) lanches.get(0);
		OpcaoCardapio opcao2 = (OpcaoCardapio) lanches.get(0);
		OpcaoCardapio opcao3 = (OpcaoCardapio) lanches.get(0);
		
		adicionarIngredienteExtraAOpcao(ingredientes.get(Ingrediente.QUEIJO), 1, opcao);
		adicionarIngredienteExtraAOpcao(ingredientes.get(Ingrediente.QUEIJO), 2, opcao2);
		adicionarIngredienteExtraAOpcao(ingredientes.get(Ingrediente.OVO), 3, opcao3);
		
		Pedido pedido = new Pedido();
		addOpcaoAoPedido(opcao, pedido);
		
	}
	
	
	/***
	 * Cria a entidade associativa do ingrediente com a opção e vincula com a opcaoCardapio
	 */
	public static void adicionarIngredienteExtraAOpcao(Ingrediente ingrediente, int qnt, OpcaoCardapio opcao){
		OpcaoIngrediente opcaoIngrediente = new OpcaoIngrediente();
			opcaoIngrediente.setOpcaoCardapio(opcao);
			opcaoIngrediente.setIngrediente(ingrediente);
			opcaoIngrediente.setQuantidade(qnt);
			
			if(opcao.getIngredientesExtras() == null)
				opcao.setIngredientesExtras(new ArrayList<>());
			opcao.getIngredientesExtras().add(opcaoIngrediente);
			System.out.println("Adicionado Ingrediente Extra: ("+opcaoIngrediente.getQuantidade()+") "
					+ ""+ingrediente.getDescricao()+" para a Opção: "+opcao.getDescricao());
	}

    /**
     * Adiciona a opção ao pedido
     * @param opcao
     */
	private static List<Pedido> addOpcaoAoPedido(OpcaoCardapio opcao, Pedido pedido) {
		
		pedido.setOpcoes(new ArrayList<OpcaoCardapio>());
		pedido.getOpcoes().add(opcao);
		pedido.setNumero(1);
		pedido.setDataCadastro(new Date());
		pedido.setValorTotal(pedido.getValorTotal());
		
		List<Pedido> todosPedidos = new ArrayList<Pedido>();
		todosPedidos.add(pedido);
		
		for (Pedido obj : todosPedidos) {
			System.out.print(""+obj.getOpcoes().size()+" opções foi adicionada ao seu pedido.");
		}
		
		return todosPedidos;
	}
	
	
	/**
	 * Esse método e responsável por chamar o strategy e calcular os valores promocionais
	 * de acordo com o tipo definido
	 * @param opcao
	 */
	public void calcularPromocaoDesconto(OpcaoCardapio opcao){
		for (OpcaoIngrediente item : opcao.getIngredientesExtras()) {
			
			if(item.getIngrediente().getId() == Ingrediente.HAMBURGUER){
				opcao.setValor(new Promocao(new PromocaoCarne()).getPrecoComDesconto(item.getOpcaoCardapio()));
			
			}else if(item.getIngrediente().getId() == Ingrediente.QUEIJO){
				opcao.setValor(new Promocao(new PromocaoQueijo()).getPrecoComDesconto(item.getOpcaoCardapio()));
			
			}else if(item.getIngrediente().getId() == Ingrediente.ALFACE){
				opcao.setValor(new Promocao(new PromocaoLight()).getPrecoComDesconto(item.getOpcaoCardapio()));
			}
			
		}
	}
	
}
