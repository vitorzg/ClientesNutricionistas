package br.com.zuconvitor.ClientesNutricionistas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zuconvitor.ClientesNutricionistas.models.Nutricionistas;


public interface NutricionistasRepository extends JpaRepository<Nutricionistas, String>{
    

    public Optional<Nutricionistas> findByEmail(String email);
}
