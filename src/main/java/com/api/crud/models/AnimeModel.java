package com.api.crud.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "anime")
public class AnimeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "El nombre no puede estar vacio.")
    private String name;

    @Column(nullable = false, length = 255)
    @Size(max = 255, message = "La descripcion no puede exceder los 255 caracteres.")
    private String description;

    @Column(nullable = false)
    @Max(value=5, message = "La puntuacion maxima es 5 puntos.")
    @Min(value=0, message = "La puntuacion debe ser mayor o igual a 0")
    private Float score;

    public Long getId() {
        return id;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
