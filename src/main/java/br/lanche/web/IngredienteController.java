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

import br.lanche.dominio.Ingrediente;
import br.lanche.repository.IngredienteRepository;
/**
 * 
 * @author Herivelton
 *
 */
@CrossOrigin
@RestController
public class IngredienteController {

	@Autowired
	IngredienteRepository repository;

	@RequestMapping(value = { "/ingredientes" })
	public List<Ingrediente> findAll() {
		return repository.findAll();
	}

	@RequestMapping(value = { "/ingrediente/{id}" })
	public Ingrediente findOne(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/ingrediente", method = RequestMethod.POST)
	public @ResponseBody Ingrediente create(@RequestBody Ingrediente ing) {
		repository.save(ing);
		return ing;
	}

	@RequestMapping(value = "/ingrediente", method = RequestMethod.PUT)
	public @ResponseBody Ingrediente update(@RequestBody Ingrediente ing) {
		repository.save(ing);
		return ing;
	}

	@RequestMapping(value = "/ingrediente/{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable("id") int id) {
		repository.delete(repository.findById(id));
		return HttpStatus.OK;
	}

}
