package com.peam.photoclone.service;

import com.peam.photoclone.model.Photo;
import com.peam.photoclone.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotoService {
    /*private Map<String, Photo> db = new HashMap<>(){{
        put("1", new Photo("1","hello.jpg"));
    }};*/

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Iterable<Photo> findAll() {
        return photoRepository.findAll();
    }

    public Photo save(String filename, String contentType, byte[] data) {
        Photo photo =new Photo();
        photo.setContentType(contentType);
        photo.setFileName(filename);
        photo.setData(data);
        photoRepository.save(photo);
        return photo;
    }

    public void remove(Integer id) {
        photoRepository.deleteById(id);
    }

    public Photo get(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }
}
