package org.example.csv_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "simulation_result")
@EntityListeners(AuditingEntityListener.class)
public class SimulationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @Column(nullable = false)
    private Integer numSimulations;  // e.g., 10000

    @Column(nullable = false)
    private String scenarioType;  // "BASELINE", "MILD_RECESSION", "SEVERE_RECESSION"

    // Results from FastAPI
    @Column(columnDefinition = "TEXT")
    private String expectedLossTimeSeries;  // JSON array of monthly expected losses

    private Double meanExpectedLoss;
    private Double medianExpectedLoss;
    private Double var95;  // 95% Value at Risk
    private Double worstCaseExpectedLoss;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime simulatedAt;
}