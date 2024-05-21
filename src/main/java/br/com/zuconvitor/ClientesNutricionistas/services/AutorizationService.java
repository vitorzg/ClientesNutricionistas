package br.com.zuconvitor.ClientesNutricionistas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.zuconvitor.ClientesNutricionistas.repositories.NutricionistasRepository;

public class AutorizationService implements UserDetailsService{

    @Autowired
    NutricionistasRepository nutricionistasRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return nutricionistasRepository.findByEmail(email);
    }
    
}
