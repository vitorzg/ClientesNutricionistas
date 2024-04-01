package br.com.zuconvitor.ClientesNutricionistas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "customers")
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomersModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_customer")
    private String id;

    @Column(name = "name_customer")
    @NotBlank(message = "name field cannot be blank")
    @Size(min = 3)
    private String name;

    @Column(name = "cpf_customer")
    @NotBlank(message = "cpf field cannot be blank")
    private String cpf;

    @Column(name = "tel_customer")
    @NotBlank(message = "tel field cannot be blank")
    private String tel;

    @Column(name = "sts_customer")
    @Size(max = 1)
    private String status;
}