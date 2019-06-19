package fr.wildcodeschool.seeknwild.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Adventure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_adventure;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private Double distance;

    @NotNull
    @NotEmpty
    private Double rate;

    @NotNull
    @NotEmpty
    private String adventure_picture;

    public Adventure() {
    }

    public Long getId_adventure() {
        return id_adventure;
    }

    public void setId_adventure(Long id_adventure) {
        this.id_adventure = id_adventure;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getAdventure_picture() {
        return adventure_picture;
    }

    public void setAdventure_picture(String adventure_picture) {
        this.adventure_picture = adventure_picture;
    }
}
