package org.example.csv_backend.dtos;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PortfolioSummaryDto {
    private Long id;
    private String name;
    private Integer accountCount;
    private Double totalEad;
    private Double delinquencyRate;
    private LocalDateTime createdAt;
}