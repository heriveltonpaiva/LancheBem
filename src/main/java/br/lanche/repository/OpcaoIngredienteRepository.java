package br.lanche.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.lanche.dominio.Ingrediente;
import br.lanche.dominio.OpcaoCardapio;
import br.lanche.dominio.OpcaoIngrediente;

@Repository
public interface OpcaoIngredienteRepository extends JpaRepository<OpcaoIngrediente, Long>{

	@Query("select i from OpcaoIngrediente i where i.id = :id")
	OpcaoIngrediente findById(@Param("id") int id);
	
	@Query("select i from OpcaoIngrediente i where i.opcaoCardapio.id = :idOpcao")
	List<OpcaoIngrediente> findIngredientesByOpcao(@Param("idOpcao") int idOpcao);
	
}
