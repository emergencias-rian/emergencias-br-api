package br.com.api.emergencias.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "t_kit_itens_ambulancia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemKitAmbulancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kit_id", nullable = false)
    private KitAmbulancia kit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estoque_id", nullable = false)
    private FarmaciaEstoque itemEstoque;

    @Column(nullable = false)
    private Integer quantidade = 1;

    private LocalDate validade;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    }