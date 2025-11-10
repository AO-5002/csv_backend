package org.example.csv_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double lgd;
    private Integer timeHorizonMonths;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Account> accounts;

    @CreatedDate
    private LocalDateTime createdAt;
}
