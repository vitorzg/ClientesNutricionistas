package br.com.zuconvitor.ClientesNutricionistas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zuconvitor.ClientesNutricionistas.models.AuthenticationDTO;
import br.com.zuconvitor.ClientesNutricionistas.models.LoginResponseDTO;
import br.com.zuconvitor.ClientesNutricionistas.models.Nutricionistas;
import br.com.zuconvitor.ClientesNutricionistas.models.RegisterDTO;
import br.com.zuconvitor.ClientesNutricionistas.repositories.NutricionistasRepository;
import br.com.zuconvitor.ClientesNutricionistas.security.TokenService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthorizationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private NutricionistasRepository repository;

    
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO dados) {
        var emailSenha = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var auth = this.authenticationManager.authenticate(emailSenha);
        
        var token = this.tokenService.generatedToken((Nutricionistas) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
    
    @PostMapping("/register")
    public ResponseEntity<Nutricionistas> register(@RequestBody @Valid RegisterDTO dados) {
        if (repository.findByEmail(dados.email()) != null) {
            return ResponseEntity.badRequest().build();
        }
        
        String eSenha = new BCryptPasswordEncoder().encode(dados.senha());
        Nutricionistas newNutricionistas = new Nutricionistas(dados.email(),eSenha,dados.nome());

        this.repository.save(newNutricionistas);

        return ResponseEntity.ok().build();
    }
    
    
}