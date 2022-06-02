package com.kreitek.kreitekfy.infrastructure.rest;

import com.kreitek.kreitekfy.application.dto.AlbumDTO;
import com.kreitek.kreitekfy.application.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlbumRestController {

    private final AlbumService albumService;

    @Autowired
    public AlbumRestController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @CrossOrigin
    @GetMapping(value = "/albums", produces = "application/json")
    ResponseEntity<List<AlbumDTO>> getAllAlbums() {
        List<AlbumDTO> albumDTOs = this.albumService.getAllAlbums();
        return new ResponseEntity<>(albumDTOs, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/album/{albumId}", produces = "application/json")
    ResponseEntity<AlbumDTO> getAlbumById(@PathVariable Long albumId) {
        Optional<AlbumDTO> albumDTOs = this.albumService.getAlbumById(albumId);
        if (albumDTOs.isPresent()) {
            return new ResponseEntity<>(albumDTOs.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/albums", produces = "application/json", consumes = "application/json")
    ResponseEntity<AlbumDTO> saveAlbum(@RequestBody AlbumDTO albumDTO) {
        AlbumDTO albumSaved = this.albumService.saveAlbum(albumDTO);
        return new ResponseEntity<>(albumSaved, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PatchMapping(value = "/albums", produces = "application/json", consumes = "application/json")
    ResponseEntity<AlbumDTO> updateAlbum(@RequestBody AlbumDTO albumDTO) {
        AlbumDTO albumUpdated = this.albumService.saveAlbum(albumDTO);
        return new ResponseEntity<>(albumUpdated, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/album/{albumId}")
    ResponseEntity<?> deleteAlbum(@PathVariable Long albumId) {
        this.albumService.deleteAlbum(albumId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
