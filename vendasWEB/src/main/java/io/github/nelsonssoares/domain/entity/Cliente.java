package io.github.nelsonssoares.domain.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//@Table(name = "tb_cliente, schema= "vendas")
@Entity
public class Cliente {
	
	
	//@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nome", length = 100)
	private String nome;
	
	//@JsonIgnore
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private Set<Pedido> pedidos;
	
	private String cpf; 
	
	public Cliente(){
		
	}
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public Cliente(Integer id, String nome, String cpf) {
		this.cpf = cpf;
		this.id = id;
		this.nome = nome;
	}
	
	
	@Column(name ="cpf", length = 11)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", pedidos=" + pedidos + ", cpf=" + cpf + "]";
	}

	
	
	
	

}
