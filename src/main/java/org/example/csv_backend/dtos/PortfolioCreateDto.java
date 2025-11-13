package org.example.csv_backend.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class PortfolioCreateDto {

    @NotBlank(message = "Portfolio name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotNull(message = "LGD is required")
    @DecimalMin(value = "0.0", message = "LGD must be at least 0")
    @DecimalMax(value = "1.0", message = "LGD must be at most 1.0")
    private Double lgd;

    @NotNull(message = "Time horizon is required")
    @Min(value = 1, message = "Time horizon must be at least 1 month")
    @Max(value = 60, message = "Time horizon must be at most 60 months")
    private Integer timeHorizonMonths;

    @NotEmpty(message = "At least one account is required")
    @Valid
    private List<AccountDto> accounts;
}