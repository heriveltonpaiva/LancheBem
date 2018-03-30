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

import br.lanche.dominio.Pedido;
import br.lanche.repository.PedidoRepository;
/**
 * 
 * @author Herivelton
 *
 */
@CrossOrigin
@RestController
public class PedidoController {

	@Autowired
	PedidoRepository repository;

	@RequestMapping(value = { "/pedidos" })
	public List<Pedido> findAll() {
		return repository.findAll();
	}

	@RequestMapping(value = { "/pedido/{id}" })
	public Pedido findOne(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "/pedido", method = RequestMethod.POST)
	public @ResponseBody Pedido create(@RequestBody Pedido ing) {
		repository.save(ing);
		return ing;
	}

	@RequestMapping(value = "/pedido", method = RequestMethod.PUT)
	public @ResponseBody Pedido update(@RequestBody Pedido ing) {
		repository.save(ing);
		return ing;
	}

	@RequestMapping(value = "/pedido/{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable("id") int id) {
		repository.delete(repository.findById(id));
		return HttpStatus.OK;
	}

}
