package org.example.csv_backend.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PortfolioCreateDto {
    private String name;
    private Double lgd;
    private Integer timeHorizonMonths;
    private List<AccountDto> accounts;
}
