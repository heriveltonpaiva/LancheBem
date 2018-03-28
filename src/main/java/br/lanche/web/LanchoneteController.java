package br.lanche.web;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lanche.dominio.Ingrediente;
import br.lanche.dominio.OpcaoCardapio;
import br.lanche.negocio.CardapioBuilder;

@CrossOrigin
@RestController
public class LanchoneteController {

	@GetMapping("/ingredientes")
	public Collection<Ingrediente> ingredientes() {
		return CardapioBuilder.montarIngredientes().values();
	}

	@GetMapping("/opcoesCardapio")
	public Collection<OpcaoCardapio> opcoesCardapio() {
		CardapioBuilder builder = new CardapioBuilder();
		return builder.montarLanches().values();
	}

}
