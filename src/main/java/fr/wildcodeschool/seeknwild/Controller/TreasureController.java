package fr.wildcodeschool.seeknwild.Controller;

import fr.wildcodeschool.seeknwild.Model.Adventure;
import fr.wildcodeschool.seeknwild.Model.Treasure;
import fr.wildcodeschool.seeknwild.Model.UserAdventure;
import fr.wildcodeschool.seeknwild.Repository.AdventureRepository;
import fr.wildcodeschool.seeknwild.Repository.TreasureRepository;
import fr.wildcodeschool.seeknwild.Repository.UserAdventureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TreasureController {

    @Autowired
    private TreasureRepository treasureRepository;

    @Autowired
    private AdventureRepository adventureRepository;

    @Autowired
    private UserAdventureRepository userAdventureRepository;

    @PostMapping("/adventure/{adventureId}/treasure")
    public Treasure create(@PathVariable Long adventureId,
                           @RequestBody Treasure treasure) {
        Adventure adventure = adventureRepository.findById(adventureId).get();
        treasure.setAdventure(adventure);
        return treasureRepository.save(treasure);
    }

    @GetMapping("/treasure")
    public List<Treasure> read() {
        return treasureRepository.findAll();
    }

    @GetMapping("/treasure/{treasureId}")
    public Treasure read(@PathVariable Long treasureId) {
        return treasureRepository.findById(treasureId).get();
    }

    @PutMapping("/treasure/{treasureId}")
    public Treasure update(@PathVariable Long treasureId,
                           @RequestBody Treasure treasure) {
        Treasure treasureToUpdate = treasureRepository.findById(treasureId).get();
        if (treasure.getDescription() != null) {
            treasureToUpdate.setDescription(treasure.getDescription());
        }
        if (treasure.getLatTreasure() != null) {
            treasureToUpdate.setLatTreasure(treasure.getLatTreasure());
        }
        if (treasure.getLongTreasure() != null) {
            treasureToUpdate.setLongTreasure(treasure.getLongTreasure());
        }
        if (treasure.getPictureTreasure() != null) {
            treasureToUpdate.setPictureTreasure(treasure.getPictureTreasure());
        }
        return treasureRepository.save(treasureToUpdate);
    }

    @DeleteMapping("/treasure/{treasureId}")
    public void delete(@PathVariable Long treasureId) {
        treasureRepository.deleteById(treasureId);
    }

    @PutMapping("/userAdventure/{userAdventureId}/treasure/{treasureId}")
    public Treasure map(@PathVariable Long userAdventureId,
                        @PathVariable Long treasureId) {
        UserAdventure userAdventure = userAdventureRepository.findById(userAdventureId).get();
        Treasure treasure = treasureRepository.findById(treasureId).get();
        treasure.getUserAdventures().add(userAdventure);
        userAdventure.getTreasures().add(treasure);
        userAdventureRepository.save(userAdventure);
        return treasureRepository.save(treasure);
    }
}




























