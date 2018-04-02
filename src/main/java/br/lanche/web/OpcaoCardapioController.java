package br.lanche.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.lanche.dominio.OpcaoCardapio;
import br.lanche.repository.OpcaoCardapioRepository;
/**
 * Classe que fornece os serviços da opção do cardápio
   @author Herivelton Paiva 
 */
@CrossOrigin
@RestController
public class OpcaoCardapioController {

	@Autowired
	OpcaoCardapioRepository repository;

	@RequestMapping(value = { "/opcoesCardapio" })
	public List<OpcaoCardapio> findAll() {
		return repository.findAll();
	}

	@RequestMapping(value = { "/opcoesCardapio/{id}" })
	public OpcaoCardapio findOne(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/opcoesCardapio", method = RequestMethod.POST)
	public @ResponseBody OpcaoCardapio create(@RequestBody OpcaoCardapio obj) {
		repository.save(obj);
		return obj;
	}

	@RequestMapping(value = "/opcoesCardapio", method = RequestMethod.PUT)
	public @ResponseBody OpcaoCardapio update(@RequestBody OpcaoCardapio obj) {
		repository.save(obj);
		return obj;
	}

	@RequestMapping(value = "/opcoesCardapio/{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable("id") int id) {
		repository.delete(repository.findById(id));
		return HttpStatus.OK;
	}
}
