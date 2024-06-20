package com.example.parcautobackend.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
@RequestMapping("/AULSH")
public class ImagesController {

    //    @GetMapping(value = "/uploads/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
//    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
//        ClassPathResource imgFile = new ClassPathResource("uploads/" + imageName);
//        byte[] bytes = Files.readAllBytes(imgFile.getFile().toPath());
//        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
//    }
    @GetMapping(value = "/uploads/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
        // Assuming your uploads directory is located at src/main/resources/uploads
        String directory = "src/main/resources/uploads/";
        Path imgPath = Paths.get(directory, imageName);

        // Check if the file exists
        if (!Files.exists(imgPath)) {
            return ResponseEntity.notFound().build();
        }

        // Read the file and convert it to byte array
        byte[] bytes = Files.readAllBytes(imgPath);

        // Return ResponseEntity with the image bytes and content type
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
    }

}
