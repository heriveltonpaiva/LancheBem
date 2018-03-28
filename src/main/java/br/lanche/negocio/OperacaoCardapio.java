package br.lanche.negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
		gerarPedidosComIngredientes();
	}

	private static void gerarPedidosComIngredientes() {
		CardapioBuilder builder = new CardapioBuilder();
		Map<Integer, OpcaoCardapio> lanches = builder.montarLanches();
		Map<Integer, Ingrediente> ingredientes = CardapioBuilder.montarIngredientes();
		
		
		/** Recupera um item do cardápio e adiciona mais ingredientes  **/
		adicionarIngrediente(ingredientes.get(Ingrediente.QUEIJO), 1, lanches.get(OpcaoCardapio.X_BACON));
		adicionarIngrediente(ingredientes.get(Ingrediente.QUEIJO), 2, lanches.get(OpcaoCardapio.X_BACON));
		adicionarIngrediente(ingredientes.get(Ingrediente.OVO), 3, lanches.get(OpcaoCardapio.X_BURGUER));
		
		
		Pedido pedido = new Pedido();
		/** Adiciona um item do cardápio ao pedido **/
		adicionarOpcaoAoPedido(lanches.get(OpcaoCardapio.X_BACON), pedido);
		adicionarOpcaoAoPedido(lanches.get(OpcaoCardapio.X_BACON), pedido);
		adicionarOpcaoAoPedido(lanches.get(OpcaoCardapio.X_BACON), pedido);
		/** Cria uma nova opção customizada para adicionar ao pedido **/
		adicionarOpcaoAoPedido(criarMontarMeuHamburguer(ingredientes.get(Ingrediente.QUEIJO)), pedido);
	}

	/** Cria o hamburguer customizado pelo cliente **/
	private static OpcaoCardapio criarMontarMeuHamburguer(Ingrediente...opcaoIngrediente){
		OpcaoCardapio opcaoNova = new OpcaoCardapio();
		opcaoNova.setDescricao("Hamburguer Feliz");
		for (Ingrediente ingrediente : Arrays.asList(opcaoIngrediente)) {
			 adicionarIngrediente(ingrediente, 1, opcaoNova);
		}
		return opcaoNova;
	}
	
	/*** Método responsável por fazer a adição da opção do cardápio ao pedido do cliente */
	private static Pedido adicionarOpcaoAoPedido(OpcaoCardapio opcao, Pedido pedido) {
		if(pedido.getOpcoes() == null)
			pedido.setOpcoes(new ArrayList<>());
		pedido.getOpcoes().add(opcao);
		pedido.setNumero(1);
		pedido.setDataCadastro(new Date());
		pedido.setValorTotal(pedido.getValorTotal()+opcao.getValor());
		
		for (OpcaoCardapio obj : pedido.getOpcoes()) {
			System.out.println(obj.getDescricao()+" - "+obj.getValor()+" foi adicionada ao seu pedido.");
		}
		System.out.println("Valor Total do Lanche:"+pedido.getValorTotal());
		return pedido;
	}
	
	/***
	 * Cria a entidade associativa do ingrediente com a opção e vincula com a opcaoCardapio
	 */
	public static void adicionarIngrediente(Ingrediente ingrediente, int qnt, OpcaoCardapio lanche){
		boolean existeIngrediente = false;
		if(lanche.getIngredientes() == null)
			lanche.setIngredientes(new ArrayList<OpcaoIngrediente>());
		for (OpcaoIngrediente opIngrediente : lanche.getIngredientes()) {
			lanche.setValorOriginal(opIngrediente.getValorTotal());
			//se o ingrediente já foi adicionado no lanche, atualiza apenas o valor da quantidade
			if(opIngrediente.getIngrediente().getId() == ingrediente.getId()){
				opIngrediente.setQuantidade(opIngrediente.getQuantidade()+qnt);
				lanche.setValor(lanche.getValor()+(ingrediente.getValor() * qnt));
				existeIngrediente = true;
				break;
			}
		}
		//se não tiver adicionado ainda o ingrediente
		if(!existeIngrediente){
		  lanche.getIngredientes().add(new OpcaoIngrediente(lanche, ingrediente, qnt));
		  lanche.setValor(lanche.getValor() + (ingrediente.getValor() * qnt));
		}
		
		//calcula o valor da promoção do lanche
		calcularPromocaoDesconto(lanche);
	}
	
	
	/**
	 * Esse método e responsável por chamar o strategy e calcular os valores promocionais
	 * de acordo com o tipo definido
	 * @param opcao
	 */
	private static void calcularPromocaoDesconto(OpcaoCardapio lanche){
		boolean possuiAlface = false;
		boolean possuiBacon = false;
		for (OpcaoIngrediente item : lanche.getIngredientes()) {
			
			if(item.getIngrediente().getId() == Ingrediente.HAMBURGUER){
				Promocao promocaoCarne = new Promocao(new PromocaoCarne());
				item.setValorDesconto(promocaoCarne.getPrecoComDesconto(item, lanche));
			}
			else if(item.getIngrediente().getId() == Ingrediente.QUEIJO){
				Promocao promocaoQueijo = new Promocao(new PromocaoQueijo());
				item.setValorDesconto(promocaoQueijo.getPrecoComDesconto(item, lanche));
			}
			// verifica se tem alface ou bacon entre os ingredientes 
			else if(item.getIngrediente().getId() == Ingrediente.ALFACE)
				possuiAlface = true;
			else if(item.getIngrediente().getId() == Ingrediente.BACON)
				possuiBacon = true;
			
		}
		
		//desconto será em cima do valor total do lanche 
		if(possuiAlface && !possuiBacon){
		 Promocao promocaoLight = new Promocao(new PromocaoLight());
		 lanche.setValor(promocaoLight.getPrecoComDesconto(null, lanche));
		}
		
	}
	
}
