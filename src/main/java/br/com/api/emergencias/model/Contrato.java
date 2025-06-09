package br.com.api.emergencias.model;

import br.com.api.emergencias.enums.StatusContrato;
import br.com.api.emergencias.enums.TipoContrato;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_contratos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //perquisar
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(nullable = false, length = 50, unique = true)
    private String numeroContrato;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoContrato tipo;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFim;

    @Column(precision = 12, scale = 2)
    private BigDecimal valorMensal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusContrato status = StatusContrato.ATIVO;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}