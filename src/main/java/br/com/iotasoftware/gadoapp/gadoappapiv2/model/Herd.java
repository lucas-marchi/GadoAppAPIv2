package br.com.iotasoftware.gadoapp.gadoappapiv2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
public class Herd {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "herd")
    private List<Bovine> bovines;
}
