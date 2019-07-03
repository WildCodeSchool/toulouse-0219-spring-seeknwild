package fr.wildcodeschool.seeknwild.Controller;

import fr.wildcodeschool.seeknwild.Model.Adventure;
import fr.wildcodeschool.seeknwild.Model.Treasure;
import fr.wildcodeschool.seeknwild.Model.User;
import fr.wildcodeschool.seeknwild.Model.UserAdventure;
import fr.wildcodeschool.seeknwild.Repository.AdventureRepository;
import fr.wildcodeschool.seeknwild.Repository.TreasureRepository;
import fr.wildcodeschool.seeknwild.Repository.UserAdventureRepository;
import fr.wildcodeschool.seeknwild.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAdventureController {

    @Autowired
    private UserAdventureRepository userAdventureRepository;

    @Autowired
    private TreasureRepository treasureRepository;

    @Autowired
    private AdventureRepository adventureRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/userAdventure")
    public UserAdventure create(@RequestBody UserAdventure userAdventure) {
        return userAdventureRepository.save(userAdventure);
    }

    @GetMapping("/userAdventure")
    public List<UserAdventure> read() {
        return userAdventureRepository.findAll();
    }

    @GetMapping("/userAdventure/{userAdventureId}")
    public UserAdventure read(@PathVariable Long userAdventureId) {
        return userAdventureRepository.findById(userAdventureId).get();
    }

    @PutMapping("/treasure/{treasureId}/userAdventure/{userAdventureId}")
    public UserAdventure mapByTreasure(@PathVariable Long userAdventureId,
                                       @PathVariable Long treasureId) {
        Treasure treasure = treasureRepository.findById(treasureId).get();
        UserAdventure userAdventure = userAdventureRepository.findById(userAdventureId).get();
        userAdventure.getTreasures().add(treasure);
        treasure.getUserAdventures().add(userAdventure);
        treasureRepository.save(treasure);
        return userAdventureRepository.save(userAdventure);
    }

    @PutMapping("user/{userId}/{userAdventureId}/{adventureId}")
    public UserAdventure updateUserAdventure(@PathVariable Long userAdventureId,
                                             @PathVariable Long userId,
                                             @PathVariable Long adventureId) {
        Adventure adventure = adventureRepository.findById(adventureId).get();
        UserAdventure userAdventure = userAdventureRepository.findById(userAdventureId).get();
        User user = userRepository.findById(userId).get();
        userAdventure.setAdventure(adventure);
        userAdventure = userAdventureRepository.save(userAdventure);
        user.setUserAdventureId(userAdventure.getIdUserAdventure());
        userRepository.save(user);
        return userAdventure;
    }

    @PostMapping("/userAdventure/treasure/{treasureId}")
    public UserAdventure createAndMapByTreasure(@PathVariable Long treasureId,
                                                @RequestBody UserAdventure userAdventure) {
        Treasure treasure = treasureRepository.findById(treasureId).get();
        userAdventure.getTreasures().add(treasure);
        treasure.getUserAdventures().add(userAdventure);
        treasureRepository.save(treasure);
        return userAdventureRepository.save(userAdventure);
    }

    @PostMapping("user/{userId}/userAdventure/{adventureId}")
    public UserAdventure startAdventure(@PathVariable Long userId,
                               @PathVariable Long adventureId) {
        Adventure adventure = adventureRepository.findById(adventureId).get();
        User user = userRepository.findById(userId).get();
        UserAdventure userAdventure = new UserAdventure();
        userAdventure.setAdventure(adventure);
        userAdventure.setUser(user);
        userAdventure.setNbTreasure(0);
        userAdventure.setCurrentTreasure(0);
        userAdventure = userAdventureRepository.save(userAdventure);
        user.setUserAdventureId(userAdventure.getIdUserAdventure());
        userRepository.save(user);
        return userAdventure;
    }
}
