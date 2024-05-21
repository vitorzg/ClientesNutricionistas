package br.com.zuconvitor.ClientesNutricionistas.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name = "nutricionistas") // Define the entity name
@Table(name = "nutricionistas") // Define the table name
@Data
public class Nutricionistas implements UserDetails{

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
    private String cpf;

    @Column(name = "tel_nutricionista")
    private String tel;

    @Column(name = "especialidade_nutricionista")
    private String especialidade;

    @OneToMany(mappedBy = "responsavel", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Pacientes> pacientes = new ArrayList<Pacientes>();

    @Column(name = "active_nutricionista")
    private Boolean active = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }

    @Override
    public String getPassword() {
        return this.getSenha();
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        throw new UnsupportedOperationException("Unimplemented method 'isAccountNonExpired'");
    }

    @Override
    public boolean isAccountNonLocked() {
        throw new UnsupportedOperationException("Unimplemented method 'isAccountNonLocked'");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        throw new UnsupportedOperationException("Unimplemented method 'isCredentialsNonExpired'");
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
    }

    public Nutricionistas(String emailReq, String eSenha, String nomeReq) {
        this.email = emailReq;
        this.senha = eSenha;
        this.nome = nomeReq;
    } 
}
