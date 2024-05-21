package br.com.zuconvitor.ClientesNutricionistas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.zuconvitor.ClientesNutricionistas.models.Nutricionistas;


public interface NutricionistasRepository extends JpaRepository<Nutricionistas, String>{
    

    UserDetails findByEmail(String email);
}
