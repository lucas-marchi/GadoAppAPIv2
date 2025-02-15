package br.com.iotasoftware.gadoapp.gadoappapiv2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "herds")
public class Herd {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "herd", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bovine> bovines = new ArrayList<>();

    public Herd() {
    }

    public Herd(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
