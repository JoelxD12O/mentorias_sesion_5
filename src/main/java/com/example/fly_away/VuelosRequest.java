package com.example.fly_away;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VuelosRequest {
    @NotBlank(message = "La aerolínea es requerida")
    private String aerolinea;

    @NotBlank(message = "El número de vuelo es requerido")
    @Pattern(regexp = "^[A-Z0-9]{1,6}$", message = "Número de vuelo debe tener máximo 6 caracteres alfanuméricos")
    private String numeroVuelo;

    @NotBlank(message = "El aeropuerto de salida es requerido")
    private String aeropuertoSalida;

    @NotBlank(message = "El aeropuerto de llegada es requerido")
    private String aeropuertoLlegada;

    @NotNull(message = "La hora de salida es requerida")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime horaSalida;

    @NotNull(message = "La hora de llegada es requerida")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime horaLlegada;

    @Min(value = 1, message = "Los asientos disponibles deben ser mayor a 0")
    private int asientosDisponibles;
}
