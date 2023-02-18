package io.github.nelsonssoares.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.github.nelsonssoares.domain.entity.Cliente;

@Repository //anotação tbm traduz as exception do DB
public interface Clientes extends JpaRepository<Cliente, Integer> {
	
	//select c from Cliente c where c.nome like :nome JPQL
	List<Cliente> findByNomeLike(String nome);
	
	List<Cliente> findByNomeOrId(String nome, Integer id);
	
	Cliente findOneByNome(String nome);
	
	boolean existsByNome(String nome);
	
}
