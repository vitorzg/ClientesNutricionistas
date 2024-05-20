package br.com.zuconvitor.ClientesNutricionistas.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.zuconvitor.ClientesNutricionistas.models.Nutricionistas;
import br.com.zuconvitor.ClientesNutricionistas.services.NutricionistasService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/APInutricionistas")
@Validated
public class NutricionistasController {
    
    private NutricionistasService nutricionistasService;

    @GetMapping("/email/{email}")
    public ResponseEntity<Nutricionistas> findOneNutricionista(@PathVariable @Valid String email) {
        Nutricionistas obj = this.nutricionistasService.findByEmail(email);
        return ResponseEntity.ok(obj);
    }
}
