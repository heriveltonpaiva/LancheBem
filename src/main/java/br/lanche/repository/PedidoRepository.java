package br.lanche.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.lanche.dominio.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	@Query("select i from Pedido i where i.id = :id")
	Pedido findById(@Param("id") int id);
	
	
}
