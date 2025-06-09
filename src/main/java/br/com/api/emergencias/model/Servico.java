package br.com.api.emergencias.model;

import br.com.api.emergencias.enums.TipoServico;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_servicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String codigo;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoServico tipo;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorPadrao;
    private Integer duracao_media; // Em minutos
    private Boolean requerVeiculo = false;
    private Boolean ativo = true;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime created_at = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updated_at = LocalDateTime.now();
}