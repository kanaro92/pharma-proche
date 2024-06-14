package mr.pharmaproche.pharmaproche.service;

import mr.pharmaproche.pharmaproche.model.Photo;
import mr.pharmaproche.pharmaproche.repository.PhotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public Long addPhoto(String originalFilename, MultipartFile image) throws IOException {
        return null;
    }

    @Override
    public Photo getPhoto(Long id) {
        return photoRepository.findById(id).get();
    }
}
