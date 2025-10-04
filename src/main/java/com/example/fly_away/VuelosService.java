package com.example.fly_away;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;

@Service
public class VuelosService {

    @Autowired
    private VuelosRepository vuelosRepository;

    public VuelosResponse crearVuelo(VuelosRequest request) {
        // Validar que hora salida < hora llegada
        if (!request.getHoraSalida().isBefore(request.getHoraLlegada())) {
            throw new VueloDataInvalidException("La hora de salida debe ser anterior a la hora de llegada");
        }

        // Validar número de vuelo único
        if (vuelosRepository.existsByNumeroVuelo(request.getNumeroVuelo())) {
            throw new VueloDataInvalidException("El número de vuelo ya existe");
        }

        // Mapear request a entidad
        Vuelos vuelo = new Vuelos();
        vuelo.setAerolinea(request.getAerolinea());
        vuelo.setNumeroVuelo(request.getNumeroVuelo());
        vuelo.setAeropuertoSalida(request.getAeropuertoSalida());
        vuelo.setAeropuertoLlegada(request.getAeropuertoLlegada());
        vuelo.setHoraSalida(request.getHoraSalida());
        vuelo.setHoraLlegada(request.getHoraLlegada());
        vuelo.setAsientosDisponibles(request.getAsientosDisponibles());
        vuelo.setEstado(EstadoVuelo.PROGRAMADO);

        // Guardar en base de datos
        Vuelos vueloGuardado = vuelosRepository.save(vuelo);

        // Mapear entidad a response
        return mapearAResponse(vueloGuardado);
    }



    private VuelosResponse mapearAResponse(Vuelos vuelo) {
        VuelosResponse response = new VuelosResponse();
        response.setId(vuelo.getId());
        response.setAerolinea(vuelo.getAerolinea());
        response.setNumeroVuelo(vuelo.getNumeroVuelo());
        response.setAeropuertoSalida(vuelo.getAeropuertoSalida());
        response.setAeropuertoLlegada(vuelo.getAeropuertoLlegada());
        response.setHoraSalida(vuelo.getHoraSalida());
        response.setHoraLlegada(vuelo.getHoraLlegada());
        response.setAsientosDisponibles(vuelo.getAsientosDisponibles());
        response.setEstado(vuelo.getEstado().name());
        return response;
    }
}
