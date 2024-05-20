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

@Entity(name = "pacientes")
@Table(name = "pacientes")
@Data
public class Pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_paciente")
    private String id;

    @Column(name = "noma_paciente")
    @NotBlank
    private String nome;

    @Column(name = "email_paciente")
    @NotBlank
    @Email
    private String email;

    @Column(name = "senha_paciente")
    @NotBlank
    private String senha;

    @Column(name = "cpf_paciente")
    @NotBlank
    private String cpf;

    @Column(name = "tel_paciente")
    @NotBlank
    private String tel;

    @Column(name = "active_paciente")
    private Boolean active = true;
    
}
