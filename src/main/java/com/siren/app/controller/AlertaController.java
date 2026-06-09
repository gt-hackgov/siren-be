package com.siren.app.controller;

import com.siren.app.model.Alerta;
import com.siren.app.repository.AlertasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alertas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlertaController {

    @Autowired
    private AlertasRepository alertasRepository;

    @GetMapping
    public ResponseEntity<List<Alerta>> getAll() {
        return ResponseEntity.ok(alertasRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerta> getById(@PathVariable Long id) {
        return alertasRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/nivel/{nivel}")
    public ResponseEntity<List<Alerta>> getByNivelUrgencia(@PathVariable Integer nivel) {
        return ResponseEntity.ok(alertasRepository.findAllByNivelUrgencia(nivel));
    }

    @PostMapping
    public ResponseEntity<Alerta> postAlerta(@Valid @RequestBody Alerta alerta) {
        if (alertasRepository.existsById(alerta.getId()))
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(alertasRepository.save(alerta));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Alerta> alerta = alertasRepository.findById(id);

        if (alerta.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        alertasRepository.deleteById(id);
    }

}
