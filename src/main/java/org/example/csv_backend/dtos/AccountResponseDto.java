package org.example.csv_backend.dtos;

import lombok.Data;

@Data
public class AccountResponseDto {
    private Long id;
    private String accountId;
    private Double balance;
    private String dpdState;
    private Integer ficoScore;
}