package org.example.csv_backend.dtos;

import lombok.Data;

@Data
public class AccountDto {
    private String accountId;
    private Double balance;
    private String dpdState;
    private Integer ficoScore;
}
