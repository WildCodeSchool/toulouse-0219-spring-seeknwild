package fr.wildcodeschool.seeknwild.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Treasure implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id_treasure;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private Double lat_treasure;

    @NotNull
    @NotEmpty
    private Double long_treasure;

    @NotNull
    @NotEmpty
    private String picture_treasure;

    public Treasure() {

    }

    public Long getId_treasure() {
        return id_treasure;
    }

    public void setId_treasure(Long id_treasure) {
        this.id_treasure = id_treasure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLat_treasure() {
        return lat_treasure;
    }

    public void setLat_treasure(Double lat_treasure) {
        this.lat_treasure = lat_treasure;
    }

    public Double getLong_treasure() {
        return long_treasure;
    }

    public void setLong_treasure(Double long_treasure) {
        this.long_treasure = long_treasure;
    }

    public String getPicture_treasure() {
        return picture_treasure;
    }

    public void setPicture_treasure(String picture_treasure) {
        this.picture_treasure = picture_treasure;
    }
}
