package org.example.csv_backend.dtos;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PortfolioResponseDto {
    private Long id;
    private String name;
    private Double lgd;
    private Integer timeHorizonMonths;
    private Integer accountCount;
    private Double totalEad;
    private Double delinquencyRate;
    private LocalDateTime createdAt;
    private List<AccountResponseDto> accounts;
}