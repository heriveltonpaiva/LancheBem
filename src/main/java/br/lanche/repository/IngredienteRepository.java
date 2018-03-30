package br.lanche.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.lanche.dominio.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{

	@Query("select i from Ingrediente i where i.id = :id")
	Ingrediente findById(@Param("id") int id);
	
	
}
