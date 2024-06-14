package mr.pharmaproche.pharmaproche.service;

import mr.pharmaproche.pharmaproche.model.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    Long addPhoto(String originalFilename, MultipartFile image) throws IOException;

    Photo getPhoto(Long id);
}
