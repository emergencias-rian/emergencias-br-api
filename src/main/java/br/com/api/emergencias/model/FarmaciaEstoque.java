package br.com.api.emergencias.model;

import br.com.api.emergencias.enums.TipoControle;
import br.com.api.emergencias.enums.TipoItemFarmacia;
import br.com.api.emergencias.enums.UnidadeMedida;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_farmacia_estoque")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FarmaciaEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String codigo;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false, length = 50)
    private String lote;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoItemFarmacia tipo;

    @Column(nullable = false)
    private Integer quantidade = 0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UnidadeMedida unidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoControle controle;

    private LocalDate validade;

    @Column(nullable = false, length = 100)
    private String localArmazenamento;

    @Column(nullable = false)
    private Integer estoqueMinimo = 0;

    @Column(nullable = false)
    private Boolean ativo = true;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    }