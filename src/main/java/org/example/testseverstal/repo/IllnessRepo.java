package org.example.testseverstal.repo;

import org.example.testseverstal.entities.Illness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IllnessRepo extends JpaRepository<Illness, Long> {
}
