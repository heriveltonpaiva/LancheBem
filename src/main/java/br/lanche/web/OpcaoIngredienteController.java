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

import br.lanche.dominio.OpcaoIngrediente;
import br.lanche.repository.OpcaoIngredienteRepository;
/**
 * 
 * @author Herivelton
 *
 */
@CrossOrigin
@RestController
public class OpcaoIngredienteController {

	@Autowired
	OpcaoIngredienteRepository repository;

	@RequestMapping(value = { "/opcaoIngrediente" })
	public List<OpcaoIngrediente> findAll() {
		return repository.findAll();
	}

	@RequestMapping(value = { "/opcaoIngrediente/{id}" })
	public OpcaoIngrediente findOne(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = { "/opcaoIngrediente/opcaoCardapio/{idOpcao}" })
	public List<OpcaoIngrediente> findIngredientesByOpcaoCardapio(@PathVariable("idOpcao") int idOpcao) {
		return repository.findIngredientesByOpcao(idOpcao);
	}

	@RequestMapping(value = "/opcaoIngrediente", method = RequestMethod.POST)
	public @ResponseBody OpcaoIngrediente create(@RequestBody OpcaoIngrediente obj) {
		repository.save(obj);
		return obj;
	}

	@RequestMapping(value = "/opcaoIngrediente", method = RequestMethod.PUT)
	public @ResponseBody OpcaoIngrediente update(@RequestBody OpcaoIngrediente obj) {
		repository.save(obj);
		return obj;
	}

	@RequestMapping(value = "/opcaoIngrediente/{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable("id") int id) {
		repository.delete(repository.findById(id));
		return HttpStatus.OK;
	}

}
