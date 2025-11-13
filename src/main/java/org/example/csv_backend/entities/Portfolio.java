package org.example.csv_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
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

    @Column(nullable = false, unique = true, updatable = false)
    private String authId;

    @Column(nullable = false, updatable = true)
    private String name;

    @Column(nullable = false, updatable = true)
    private Double lgd;

    @Column(nullable = false, updatable = true)
    private Integer timeHorizonMonths;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Account> accounts;

    @CreatedDate
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
