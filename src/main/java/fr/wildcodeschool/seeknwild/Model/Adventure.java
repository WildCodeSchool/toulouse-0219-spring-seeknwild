package fr.wildcodeschool.seeknwild.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
public class Adventure implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdventure;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String description;

    private Double distance;

    private Double rate;

    @NotNull
    @NotEmpty
    private String adventure_picture;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adventure")
    private List<Treasure> treasures;

    @OneToOne(mappedBy = "adventure")
    private UserAdventure userAdventure;

    public Adventure() {
    }

    public UserAdventure getUserAdventure() {
        return userAdventure;
    }

    public void setUserAdventure(UserAdventure userAdventure) {
        this.userAdventure = userAdventure;
    }

    public Long getIdAdventure() {
        return idAdventure;
    }

    public void setIdAdventure(Long idAdventure) {
        this.idAdventure = idAdventure;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }
}
