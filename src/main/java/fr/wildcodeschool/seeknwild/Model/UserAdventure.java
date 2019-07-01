package fr.wildcodeschool.seeknwild.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserAdventure implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserAdventure;

    private int nbTreasure;
    private Long currentTreasure;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAdventure", referencedColumnName = "idAdventure")
    private Adventure adventure;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "userAdventures")
    @JsonIgnore
    private List<Treasure> treasures = new ArrayList<>();

    public UserAdventure() {
    }

    public Long getIdUserAdventure() {
        return idUserAdventure;
    }

    public void setIdUserAdventure(Long idUserAdventure) {
        this.idUserAdventure = idUserAdventure;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Adventure getAdventure() {
        return adventure;
    }

    public void setAdventure(Adventure adventure) {
        this.adventure = adventure;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    public int getNbTreasure() {
        return nbTreasure;
    }

    public void setNbTreasure(int nbTreasure) {
        this.nbTreasure = nbTreasure;
    }

    public Long getCurrentTreasure() {
        return currentTreasure;
    }

    public void setCurrentTreasure(Long currentTreasure) {
        this.currentTreasure = currentTreasure;
    }
}