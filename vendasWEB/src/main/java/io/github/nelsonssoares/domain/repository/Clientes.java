package io.github.nelsonssoares.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import io.github.nelsonssoares.domain.entity.Cliente;

@Repository //anotação tbm traduz as exception do DB
public interface Clientes extends JpaRepository<Cliente, Integer> {
	
	//select c from Cliente c where c.nome like :nome JPQL
	//@Query(value = "select * from cliente c where c.nome like '%:nome%'", nativeQuery = true)
	@Query(value = "select c from Cliente c where c.nome like :nome")
	List<Cliente> findByNomeLike(@Param("nome") String nome);
	
	List<Cliente> findByNomeOrId(String nome, Integer id);
	
	
	@Query(value = "delete from Cliente c where c.nome = :nome")
	@Modifying // para excluir ou atualizar campo
	void deleteByNome(String nome); 
	
	Cliente findOneByNome(String nome);
	
	boolean existsByNome(String nome);
	
	@Query("select c from Cliente c left join fetch c.pedidos where c.id = :id")
	Cliente findClienteFetchPedidos(@Param("id") Integer id);
	
	
	
}
