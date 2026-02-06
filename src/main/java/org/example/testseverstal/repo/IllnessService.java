package org.example.testseverstal.repo;

import jakarta.persistence.EntityNotFoundException;
import org.example.testseverstal.entities.Illness;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllnessService {

    private final IllnessRepo repo;

    public IllnessService(IllnessRepo repo) {
        this.repo = repo;
    }

    public List<Illness> findAll() {
        return repo.findAll();
    }

    public Illness findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Illness save(Illness illness) {
        return repo.save(illness);
    }
    public void delete(long id) {
        repo.deleteById(id);
    }

    public Illness update(Illness illness) {
        Illness existing = repo.findById(illness.getId())
                .orElseThrow(() -> new EntityNotFoundException("Illness not found with id " + illness.getId()));
        existing.setName(illness.getName());
        return repo.save(existing);
    }
}
