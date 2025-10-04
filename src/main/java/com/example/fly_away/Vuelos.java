package com.example.fly_away;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Vuelos {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String aerolinea;

    @NotBlank
    @Pattern(regexp = "^[A-Z0-9]{1,6}$")
    @Column(unique = true)
    private String numeroVuelo;

    @NotBlank
    private String aeropuertoSalida;

    @NotBlank
    private String aeropuertoLlegada;

    @NotNull
    private LocalDateTime horaSalida;

    @NotNull
    private LocalDateTime horaLlegada;

    @Min(1)
    private int asientosDisponibles;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoVuelo estado = EstadoVuelo.PROGRAMADO;
}
