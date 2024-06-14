package mr.pharmaproche.pharmaproche.controller;

import mr.pharmaproche.pharmaproche.model.Photo;
import mr.pharmaproche.pharmaproche.service.PhotoService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/pharma-proche/photo")
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping
    public Long addPhoto(@RequestParam("image")MultipartFile image) throws IOException {
        Long id = photoService.addPhoto(image.getOriginalFilename(), image);
        return id;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Resource> downloadPhoto(@PathVariable Long id) {
//        Photo photo = photoService.getPhoto(id);
//        Resource resource = new ByteArrayResource(photo.getPhoto().getData());
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+photo.getTitle()+"\"")
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(resource);
//    }
}
