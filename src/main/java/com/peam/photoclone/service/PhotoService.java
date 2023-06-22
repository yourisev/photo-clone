package com.peam.photoclone.service;

import com.peam.photoclone.model.Photo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotoService {
    private Map<String, Photo> db = new HashMap<>(){{
        put("1", new Photo("1","hello.jpg"));
    }};

    public Collection<Photo> findAll() {
        return db.values();
    }

    public Photo save(String filename, String contentType, byte[] data) {
        Photo photo =new Photo();
        photo.setContentType(contentType);
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(filename);
        photo.setData(data);
        db.put(photo.getId(), photo);
        return photo;
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo get(String id) {
        return db.get(id);
    }
}
