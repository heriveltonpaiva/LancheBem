package br.lanche.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.lanche.dominio.OpcaoCardapio;

@Repository
public interface OpcaoCardapioRepository extends JpaRepository<OpcaoCardapio, Long>{

	@Query("select i from OpcaoCardapio i where i.id = :id")
	OpcaoCardapio findById(@Param("id") int id);
	
}
