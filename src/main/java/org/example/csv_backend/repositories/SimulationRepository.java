package org.example.csv_backend.repositories;


import org.example.csv_backend.entities.SimulationResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimulationRepository extends JpaRepository<SimulationResult, Long> {
    List<SimulationResult> findByPortfolioIdOrderBySimulatedAtDesc(Long portfolioId);
}