package org.example.csv_backend.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AccountDto {

    @NotBlank(message = "Account ID is required")
    private String accountId;

    @NotNull(message = "Balance is required")
    @DecimalMin(value = "0.01", message = "Balance must be positive")
    private Double balance;

    @NotBlank(message = "DPD state is required")
    @Pattern(regexp = "CURRENT|30_DPD|60_DPD|90_DPD|DEFAULT",
            message = "Invalid DPD state")
    private String dpdState;

    @NotNull(message = "FICO score is required")
    @Min(value = 300, message = "FICO score must be at least 300")
    @Max(value = 850, message = "FICO score must be at most 850")
    private Integer ficoScore;
}
