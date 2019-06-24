package fr.wildcodeschool.seeknwild.Controller;

import fr.wildcodeschool.seeknwild.Model.Adventure;
import fr.wildcodeschool.seeknwild.Model.User;
import fr.wildcodeschool.seeknwild.Repository.AdventureRepository;
import fr.wildcodeschool.seeknwild.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdventureController {

    @Autowired
    private AdventureRepository adventureRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/{userId}/adventure")
    public Adventure create(@PathVariable Long userId,
                            @RequestBody Adventure adventure) {
        User user = userRepository.findById(userId).get();
        adventure.setUser(user);
        return adventureRepository.save(adventure);
    }

    @GetMapping("/adventure/{adventureId}")
    public Adventure read(@PathVariable Long adventureId) {
        return adventureRepository.findById(adventureId).get();
    }

    @GetMapping("/adventure")
    public List<Adventure> read() {
        return adventureRepository.findAll();
    }

    @PutMapping("/adventure/{adventureId}")
    public Adventure update(@PathVariable Long adventureId,
                            @RequestBody Adventure adventure) {
        Adventure adventureToUpdate = adventureRepository.findById(adventureId).get();
        if (adventure.getTitle() != null) {
            adventureToUpdate.setTitle(adventure.getTitle());
        }
        if (adventure.getDescription() != null) {
            adventureToUpdate.setDescription(adventure.getDescription());
        }
        if (adventure.getDistance() != null) {
            adventureToUpdate.setDistance(adventure.getDistance());
        }
        if (adventure.getRate() != null) {
            adventureToUpdate.setRate(adventure.getRate());
        }
        if (adventure.getAdventure_picture() != null) {
            adventureToUpdate.setAdventure_picture(adventure.getAdventure_picture());
        }
        return adventureRepository.save(adventureToUpdate);
    }

    @DeleteMapping("/adventure/{adventureId}")
    public void delete(@PathVariable Long adventureId) {
        adventureRepository.deleteById(adventureId);
    }
}
