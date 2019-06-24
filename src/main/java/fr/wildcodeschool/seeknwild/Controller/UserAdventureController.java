package fr.wildcodeschool.seeknwild.Controller;

import fr.wildcodeschool.seeknwild.Model.Treasure;
import fr.wildcodeschool.seeknwild.Model.UserAdventure;
import fr.wildcodeschool.seeknwild.Repository.TreasureRepository;
import fr.wildcodeschool.seeknwild.Repository.UserAdventureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAdventureController {

    @Autowired
    private UserAdventureRepository userAdventureRepository;

    @Autowired
    private TreasureRepository treasureRepository;

    @PostMapping("/userAdventure")
    public UserAdventure create(@RequestBody UserAdventure userAdventure) {
        return userAdventureRepository.save(userAdventure);
    }

    @PutMapping("/treasure/{treasureId}/userAdventure/{userAdventureId}")
    public UserAdventure map(@PathVariable Long userAdventureId,
                             @PathVariable Long treasureId) {
        Treasure treasure = treasureRepository.findById(treasureId).get();
        UserAdventure userAdventure = userAdventureRepository.findById(userAdventureId).get();
        userAdventure.getTreasures().add(treasure);
        treasure.getUserAdventures().add(userAdventure);
        treasureRepository.save(treasure);
        return userAdventureRepository.save(userAdventure);
    }

    @PostMapping("/userAdventure/treasure/{treasureId}")
    public UserAdventure createAndMap(@PathVariable Long treasureId,
                                      @RequestBody UserAdventure userAdventure) {
        Treasure treasure = treasureRepository.findById(treasureId).get();
        userAdventure.getTreasures().add(treasure);
        treasure.getUserAdventures().add(userAdventure);
        treasureRepository.save(treasure);
        return userAdventureRepository.save(userAdventure);
    }

}
