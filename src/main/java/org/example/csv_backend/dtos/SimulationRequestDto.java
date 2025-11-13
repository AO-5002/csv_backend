package org.example.csv_backend.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SimulationRequestDto {

    @NotNull(message = "Portfolio ID is required")
    private Long portfolioId;

    @NotNull(message = "Number of simulations is required")
    @Min(value = 100, message = "At least 100 simulations required")
    @Max(value = 100000, message = "Maximum 100,000 simulations")
    private Integer numSimulations;

    @NotBlank(message = "Scenario type is required")
    @Pattern(regexp = "BASELINE|MILD_RECESSION|SEVERE_RECESSION",
            message = "Invalid scenario type")
    private String scenarioType;
}