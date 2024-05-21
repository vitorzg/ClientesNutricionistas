package br.com.zuconvitor.ClientesNutricionistas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.com.zuconvitor.ClientesNutricionistas.models.Nutricionistas;
import br.com.zuconvitor.ClientesNutricionistas.repositories.NutricionistasRepository;
import jakarta.transaction.Transactional;

@Service
public class NutricionistasService {
    
    @Autowired
    private NutricionistasRepository nutricionistasRepository;

    public Nutricionistas findById(String id) {
        Optional<Nutricionistas> nutricionista = nutricionistasRepository.findById(id);
        return nutricionista.orElseThrow(() -> new RuntimeException("Nutricionista not found"));
    }

    public List<Nutricionistas> findAll() {
        return nutricionistasRepository.findAll();
    }

    @Transactional
    public Nutricionistas update(Nutricionistas nutricionista) {
        Nutricionistas existingNutricionista = findById(nutricionista.getId()); // Ensure existence

        existingNutricionista.setNome(nutricionista.getNome());
        existingNutricionista.setEmail(nutricionista.getEmail());
        existingNutricionista.setCpf(nutricionista.getCpf());
        existingNutricionista.setTel(nutricionista.getTel());
        existingNutricionista.setEspecialidade(nutricionista.getEspecialidade());

        return nutricionistasRepository.save(existingNutricionista);
    }

    @Transactional
    public void delete(String id) {
        Nutricionistas nutricionista = findById(id); // Ensure existence

        try {
            nutricionistasRepository.delete(nutricionista);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Unable to delete nutricionista. " +
                    "Check for any dependent entities or database constraints.");
        }
    }
}
