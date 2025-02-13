package br.com.iotasoftware.gadoapp.gadoappapiv2.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Bovine {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = true)
    private String breed;

    @Column(nullable = true)
    private Double weight;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(length = 500, nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "herd_id")
    private Herd herd;
}
