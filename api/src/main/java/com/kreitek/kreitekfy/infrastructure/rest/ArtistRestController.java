package com.kreitek.kreitekfy.infrastructure.rest;

import com.kreitek.kreitekfy.application.dto.ArtistDTO;
import com.kreitek.kreitekfy.application.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArtistRestController {

    private final ArtistService artistService;

    @Autowired
    public ArtistRestController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @CrossOrigin
    @GetMapping(value = "/artists", produces = "application/json")
    ResponseEntity<List<ArtistDTO>> getAllArtists() {
        List<ArtistDTO> artistDTOs = this.artistService.getAllArtists();
        return new ResponseEntity<>(artistDTOs, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/artist/{artistId}", produces = "application/json")
    ResponseEntity<ArtistDTO> getArtistById(@PathVariable Long artistId) {
        Optional<ArtistDTO> artistDTOs = this.artistService.getArtistById(artistId);
        if (artistDTOs.isPresent()) {
            return new ResponseEntity<>(artistDTOs.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/artists", produces = "application/json")
    ResponseEntity<ArtistDTO> saveArtist(@RequestBody ArtistDTO artistDTO) {
        ArtistDTO artistSaved = this.artistService.saveArtist(artistDTO);
        return new ResponseEntity<>(artistSaved, HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping(value = "/artist/{artistId}")
    ResponseEntity<?> deleteArtist(@PathVariable Long artistId) {
        this.artistService.deleteArtist(artistId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
