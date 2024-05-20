package br.com.zuconvitor.ClientesNutricionistas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zuconvitor.ClientesNutricionistas.models.Pacientes;
import br.com.zuconvitor.ClientesNutricionistas.repositories.PacientesRepository;

@Service
public class PacientesService {

    @Autowired
    private PacientesRepository pacientesRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Pacientes create(Pacientes paciente) {
        paciente.setId(null);
        paciente.setSenha(passwordEncoder.encode(paciente.getSenha())); // Hash password before saving
        paciente = pacientesRepository.save(paciente);
        return paciente;
    }

    public Pacientes findById(String id) {
        Optional<Pacientes> paciente = pacientesRepository.findById(id);
        return paciente.orElseThrow(() -> new RuntimeException("Paciente not found"));
    }

    public List<Pacientes> findAll() {
        return pacientesRepository.findAll();
    }

    public Pacientes findByEmail(String email) {
        Optional<Pacientes> paciente = pacientesRepository.findByEmail(email);
        return paciente.orElseThrow(() -> new RuntimeException("Paciente not found with email: " + email));
    }

    @Transactional
    public Pacientes update(Pacientes paciente) {
        Pacientes existingPaciente = findById(paciente.getId());

        existingPaciente.setNome(paciente.getNome());
        existingPaciente.setEmail(paciente.getEmail());
        if (paciente.getSenha() != null && !paciente.getSenha().isEmpty()) {
            existingPaciente.setSenha(passwordEncoder.encode(paciente.getSenha()));
        }
        existingPaciente.setCpf(paciente.getCpf());
        existingPaciente.setTel(paciente.getTel());
        existingPaciente.setActive(paciente.getActive());

        return pacientesRepository.save(existingPaciente);
    }

    @Transactional
    public void delete(String id) {
        Pacientes paciente = findById(id); // Ensure existence

        try {
            pacientesRepository.delete(paciente);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Unable to delete paciente. " +
                    "Check for any dependent entities or database constraints.");
        }
    }
}
