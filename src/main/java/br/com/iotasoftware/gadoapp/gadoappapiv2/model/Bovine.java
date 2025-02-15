package br.com.iotasoftware.gadoapp.gadoappapiv2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bovines")
public class Bovine {
    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String gender;

    private String breed;

    private Double weight;

    @Column(nullable = false)
    private Date birth;

    private String description;

    @Column(nullable = false)
    private Integer herdId;

    private Integer momId;

    private Integer dadId;

    public Bovine() {
    }
}
