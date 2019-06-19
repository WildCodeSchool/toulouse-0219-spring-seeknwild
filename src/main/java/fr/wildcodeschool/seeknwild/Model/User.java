package fr.wildcodeschool.seeknwild.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @NotNull
    @NotEmpty
    private String pseudo;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Adventure> adventures;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Picture> pictures;

    @OneToOne(mappedBy = "user")
    private UserAdventure userAdventure;

    public UserAdventure getUserAdventure() {
        return userAdventure;
    }

    public void setUserAdventure(UserAdventure userAdventure) {
        this.userAdventure = userAdventure;
    }

    public User() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Adventure> getAdventures() {
        return adventures;
    }

    public void setAdventures(List<Adventure> adventures) {
        this.adventures = adventures;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
