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

@Entity(name = "nutritionists")
@Table(name = "nutritionists")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NutritionistsModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_nutritionist")
    private String id;

    @Column(name = "name_nutritionist")
    @NotBlank(message = "name field cannot be blank")
    @Size(min = 3)
    private String name;

    @Column(name = "cpf_nutritionist")
    @NotBlank(message = "cpf field cannot be blank")
    private String cpf;

    @Column(name = "tel_nutritionist")
    @NotBlank(message = "tel field cannot be blank")
    private String tel;

    @Column(name = "sts_nutritionist")
    @Size(max = 1)
    private String status;

    @Column(name = "crn_nutritionist")
    private String cnr_number;

    @Column(name = "specialization_nutritionist")
    private String specialization;
}
