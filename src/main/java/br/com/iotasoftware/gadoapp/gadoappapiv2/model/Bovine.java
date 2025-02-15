package br.com.iotasoftware.gadoapp.gadoappapiv2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "bovines")
public class Bovine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String gender;

    private String breed;

    private Double weight;

    @Column(nullable = false)
    private LocalDate birth;

    private String description;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "herd_id")
    private Herd herd;

    @ManyToOne
    @JoinColumn(name = "mom_id")
    private Bovine mom;

    @ManyToOne
    @JoinColumn(name = "dad_id")
    private Bovine dad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Herd getHerd() {
        return herd;
    }

    public void setHerd(Herd herd) {
        this.herd = herd;
    }

    public Bovine getMom() {
        return mom;
    }

    public void setMom(Bovine mom) {
        this.mom = mom;
    }

    public Bovine getDad() {
        return dad;
    }

    public void setDad(Bovine dad) {
        this.dad = dad;
    }
}
