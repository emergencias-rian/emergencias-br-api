package br.com.api.emergencias.model;

import br.com.api.emergencias.enums.StatusAgenda;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "t_agenda")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento com Cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    // Relacionamento com Servico
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servico_id", nullable = false)
    private ServicoManutencao servico;

    private LocalDate data;
    private LocalTime hora;

    @Column(name = "local_atendimento", nullable = false)
    private String localAtendimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAgenda status = StatusAgenda.AGENDADO;

    private String observacoes;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}
