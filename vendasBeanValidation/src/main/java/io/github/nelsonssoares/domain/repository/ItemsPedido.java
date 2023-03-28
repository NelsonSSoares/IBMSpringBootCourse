package io.github.nelsonssoares.domain.repository;

import io.github.nelsonssoares.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer> {
}
