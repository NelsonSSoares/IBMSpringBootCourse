package io.github.nelsonssoares.domain.entity;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    @Column(name = "descricao")
    private String descricao;
    
    @NotNull(message = "{campo.preco.obrigatorio}")
    @Column(name = "preco_unitario")
    private BigDecimal preco;

}
