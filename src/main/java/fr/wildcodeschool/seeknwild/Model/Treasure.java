package fr.wildcodeschool.seeknwild.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Treasure implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idTreasure;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private Double latTreasure;

    @NotNull
    @NotEmpty
    private Double longTreasure;

    @NotNull
    @NotEmpty
    private String pictureTreasure;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private Adventure adventure;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "userAdventureTreasure",
            joinColumns = {@JoinColumn(name = "idUserAdventure")},
            inverseJoinColumns = {@JoinColumn(name = "idTreasure")})
    private List<UserAdventure> userAdventures = new ArrayList<>();

    public Treasure() {

    }

    public Long getIdTreasure() {
        return idTreasure;
    }

    public void setIdTreasure(Long idTreasure) {
        this.idTreasure = idTreasure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLatTreasure() {
        return latTreasure;
    }

    public void setLatTreasure(Double latTreasure) {
        this.latTreasure = latTreasure;
    }

    public Double getLongTreasure() {
        return longTreasure;
    }

    public void setLongTreasure(Double longTreasure) {
        this.longTreasure = longTreasure;
    }

    public String getPictureTreasure() {
        return pictureTreasure;
    }

    public void setPictureTreasure(String pictureTreasure) {
        this.pictureTreasure = pictureTreasure;
    }

    public Adventure getAdventure() {
        return adventure;
    }

    public void setAdventure(Adventure adventure) {
        this.adventure = adventure;
    }

    public List<UserAdventure> getUserAdventures() {
        return userAdventures;
    }

    public void setUserAdventures(List<UserAdventure> userAdventures) {
        this.userAdventures = userAdventures;
    }
}
