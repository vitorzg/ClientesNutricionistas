package br.com.zuconvitor.ClientesNutricionistas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name = "nutricionistas") // Define the entity name
@Table(name = "nutricionistas") // Define the table name
@Data
public class Nutricionistas{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_nutricionista")
    private String id;

    @Column(name = "nome_nutricionista")
    @NotBlank
    private String nome;

    @Column(name = "email_nutricionista")
    @NotBlank
    @Email
    private String email;

    @Column(name = "senha_nutricionista")
    @NotBlank
    private String senha;

    @Column(name = "cpf_nutricionista")
    @NotBlank
    private String cpf;

    @Column(name = "tel_nutricionista")
    @NotBlank
    private String tel;

    @Column(name = "especialidade_nutricionista")
    @NotBlank
    private String especialidade;

    @Column(name = "active_nutricionista")
    private Boolean active = true; 
}
