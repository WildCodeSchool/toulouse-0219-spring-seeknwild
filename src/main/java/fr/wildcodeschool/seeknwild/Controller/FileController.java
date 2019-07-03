package fr.wildcodeschool.seeknwild.Controller;

import fr.wildcodeschool.seeknwild.Model.Adventure;
import fr.wildcodeschool.seeknwild.Model.Picture;
import fr.wildcodeschool.seeknwild.Model.Treasure;
import fr.wildcodeschool.seeknwild.Model.User;
import fr.wildcodeschool.seeknwild.Repository.AdventureRepository;
import fr.wildcodeschool.seeknwild.Repository.PictureRepository;
import fr.wildcodeschool.seeknwild.Repository.TreasureRepository;
import fr.wildcodeschool.seeknwild.Repository.UserRepository;
import fr.wildcodeschool.seeknwild.Service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private AdventureRepository adventureRepository;
    @Autowired
    private TreasureRepository treasureRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PictureRepository pictureRepository;

    @PostMapping("/adventure/{idAdventure}/picture")
    public String uploadFile(@PathVariable Long idAdventure,
            @RequestParam("file") MultipartFile file) {

        Adventure adventure = adventureRepository.findById(idAdventure).get();

        String fileName = fileStorageService.storeFile(file);

        String filePath = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        adventure.setAdventurePicture(filePath);
        adventureRepository.save(adventure);

        return filePath;
    }

    @PostMapping("treasure/{idTreasure}/picture")
    public String uploadTreasurePicture(@PathVariable Long idTreasure,
                             @RequestParam("file") MultipartFile file) {

        Treasure treasure = treasureRepository.findById(idTreasure).get();

        String fileName = fileStorageService.storeFile(file);

        String filePath = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        treasure.setPictureTreasure(filePath);
        treasureRepository.save(treasure);

        return filePath;
    }

    @PostMapping("user/{idUser}/picture")
    public String uploadPicUser(@PathVariable Long idUser,
                                        @RequestParam("file") MultipartFile file) {


        User user = userRepository.findById(idUser).get();
        Picture picture = pictureRepository.findById(idUser).get();

        String fileName = fileStorageService.storeFile(file);

        String filePath = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        picture.setUrlPicture(filePath);
        pictureRepository.save(picture);

        return filePath;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
