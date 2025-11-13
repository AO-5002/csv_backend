package org.example.csv_backend.dtos;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SimulationResultDto {
    private Long id;
    private Long portfolioId;
    private Integer numSimulations;
    private String scenarioType;
    private List<Double> expectedLossTimeSeries;  // Monthly expected losses
    private Double meanExpectedLoss;
    private Double medianExpectedLoss;
    private Double var95;
    private Double worstCaseExpectedLoss;
    private LocalDateTime simulatedAt;
}