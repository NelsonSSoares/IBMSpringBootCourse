package io.github.nelsonssoares.domain.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.github.nelsonssoares.domain.entity.Cliente;

@Repository //anotação tbm traduz as exception do DB
public class Clientes {
	
	private static String INSERT = "INSERT INTO CLIENTE (NOME) VALUES (?)";
	private static String SELECT_ALL = "SELECT * FROM CLIENTE";
	private static String UPDATE = "UPDATE CLIENTE SET NOME = ? WHERE ID = ?";
	private static String DELETE = "DELETE FROM CLIENTE WHERE ID = ?";
	//private static String SELECT_POR_NOME = "SELECT FROM CLIENTE WHERE ID = ?";
	
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Cliente salvar(Cliente cliente) {
		jdbcTemplate.update(INSERT, new Object[] {cliente.getNome()});
		return cliente;
	}
	
	public List<Cliente>obterTodos(){
		return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>() {

			@Override
			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String nome = rs.getString("nome");
				return new Cliente(id, nome);
			}
			
		});
	}
	
	
	public Cliente atualiza(Cliente cliente) {
		jdbcTemplate.update(UPDATE, new Object[] {
			cliente.getId(),cliente.getNome()});
		
		return cliente;
	}
	
//	public void deletar(Cliente cliente ) {
//		deletar(cliente.getId());
//	}
	
	public void deletar(Integer id) {
		jdbcTemplate.update(DELETE, new Object[] {id});
	}
	
	
	public List<Cliente> buscarPorNome(String nome) {
		return jdbcTemplate.query(SELECT_ALL.concat(" WHERE NOME LIKE ?"), new Object[] {
				"%"+nome+"%"}, obterClienteMapper());
	}
	
	private RowMapper<Cliente> obterClienteMapper() {
		return new RowMapper<Cliente>() {

			@Override
			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String nome = rs.getString("nome");
				return new Cliente(id, nome);
			}
		
		};
	}
	
	
}
