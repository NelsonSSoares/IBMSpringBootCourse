package io.github.nelsonssoares.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nelsonssoares.domain.entity.ItemPedido;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer> {

}
