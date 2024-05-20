package br.com.zuconvitor.ClientesNutricionistas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zuconvitor.ClientesNutricionistas.models.Pacientes;

public interface PacientesRepository extends JpaRepository<Pacientes, String>{

    public Optional<Pacientes> findByEmail(String email);
    
}
