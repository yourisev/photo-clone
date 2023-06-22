package com.peam.photoclone.web;

import com.peam.photoclone.service.PhotoService;
import com.peam.photoclone.model.Photo;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {

    private final PhotoService photoService;

    public DownloadController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id){
       Photo photo = photoService.get(id);

       if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

       byte[] data = photo.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition build = ContentDisposition.
                builder("attachment").
                filename(photo.getFileName()).
                build();//inline instead of attachment displays the content in the browser
        headers.setContentDisposition(build);
        //MultiValueMap<String, String> headers;
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
