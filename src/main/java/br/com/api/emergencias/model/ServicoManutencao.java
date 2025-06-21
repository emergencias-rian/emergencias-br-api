package br.com.api.emergencias.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "t_manutencao_servicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicoManutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manutencao_id", nullable = false)
    private ManutencaoVeiculo manutencao;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal custo;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

}