package br.com.zuconvitor.ClientesNutricionistas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.zuconvitor.ClientesNutricionistas.models.Nutricionistas;
import br.com.zuconvitor.ClientesNutricionistas.services.NutricionistasService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/nutricionistas")
public class NutricionistasController {

    @Autowired
    private NutricionistasService nutricionistasService;

    @PostMapping
    public ResponseEntity<Nutricionistas> createNutricionista(@Valid @RequestBody Nutricionistas nutricionista) {
        Nutricionistas createdNutricionista = nutricionistasService.create(nutricionista);
        return ResponseEntity.ok(createdNutricionista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nutricionistas> findNutricionistaById(@Valid @PathVariable String id) {
        Nutricionistas nutricionista = nutricionistasService.findById(id);
        return ResponseEntity.ok(nutricionista);
    }

    @GetMapping
    public ResponseEntity<List<Nutricionistas>> findAllNutricionistas() {
        List<Nutricionistas> nutricionistas = nutricionistasService.findAll();
        return ResponseEntity.ok(nutricionistas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nutricionistas> updateNutricionista(@Valid @PathVariable String id, @RequestBody Nutricionistas nutricionista) {
        nutricionista.setId(id);
        Nutricionistas updatedNutricionista = nutricionistasService.update(nutricionista);
        return ResponseEntity.ok(updatedNutricionista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNutricionista(@PathVariable String id) {
        nutricionistasService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
