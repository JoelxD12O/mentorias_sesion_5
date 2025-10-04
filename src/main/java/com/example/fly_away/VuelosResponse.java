package com.example.fly_away;


import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

@Data
public class VuelosResponse {
    private Long id;
    private String aerolinea;
    private String numeroVuelo;
    private String aeropuertoSalida;
    private String aeropuertoLlegada;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime horaSalida;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime horaLlegada;
    private int asientosDisponibles;
    private String estado;
}