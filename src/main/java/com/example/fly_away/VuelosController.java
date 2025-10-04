package com.example.fly_away;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VuelosController {

    @Autowired
    private VuelosService vuelosService;

    @PostMapping("/crear")
    public ResponseEntity<VuelosResponse> crearVuelo(@Valid @RequestBody VuelosRequest request) {
        VuelosResponse response = vuelosService.crearVuelo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}