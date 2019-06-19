package fr.wildcodeschool.seeknwild.Controller;

import fr.wildcodeschool.seeknwild.Model.Picture;
import fr.wildcodeschool.seeknwild.Model.User;
import fr.wildcodeschool.seeknwild.Repository.PictureRepository;
import fr.wildcodeschool.seeknwild.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PictureController {

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/{userId}/picture")
    public Picture create(@PathVariable Long userId,
                          @RequestBody Picture picture) {
        User user = userRepository.findById(userId).get();
        picture.setUser(user);
        return pictureRepository.save(picture);
    }

    @GetMapping("/picture")
    public List<Picture> read() {
        return pictureRepository.findAll();
    }

    @GetMapping("/picture/{pictureId}")
    public Picture read(@PathVariable Long pictureId) {
        return pictureRepository.findById(pictureId).get();
    }

    @PutMapping("/picture/{pictureId}")
    public Picture update(@PathVariable Long pictureId,
                          @RequestBody Picture picture) {
        Picture pictureToUpdate = pictureRepository.findById(pictureId).get();
        if (picture.getUrlPicture() != null) {
            pictureToUpdate.setUrlPicture(picture.getUrlPicture());
        }
        return pictureRepository.save(pictureToUpdate);
    }

    @DeleteMapping("/picture/{pictureId}")
    public void delete(@PathVariable Long pictureId) {
        pictureRepository.deleteById(pictureId);
    }

}
