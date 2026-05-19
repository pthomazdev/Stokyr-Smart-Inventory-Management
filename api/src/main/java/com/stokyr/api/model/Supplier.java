package com.stokyr.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="supplier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Supplier name is required")
    @Column(nullable = false, length = 120)
    private String name;

    @Email(message = "Invalid email")
    @Column(length = 120)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
