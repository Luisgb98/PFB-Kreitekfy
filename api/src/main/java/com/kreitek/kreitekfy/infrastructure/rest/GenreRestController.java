package com.kreitek.kreitekfy.infrastructure.rest;

import com.kreitek.kreitekfy.application.dto.GenreDTO;
import com.kreitek.kreitekfy.application.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GenreRestController {

    private final GenreService genreService;

    @Autowired
    public GenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @CrossOrigin
    @GetMapping(value = "/genres", produces = "application/json")
    ResponseEntity<List<GenreDTO>> getAllGenres() {
        List<GenreDTO> genreDTOs = this.genreService.getAllGenres();
        return new ResponseEntity<>(genreDTOs, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/genre/{genreId}", produces = "application/json")
    ResponseEntity<GenreDTO> getGenreById(@PathVariable Long genreId) {
        Optional<GenreDTO> genreDTOs = this.genreService.getGenreById(genreId);
        if (genreDTOs.isPresent()) {
            return new ResponseEntity<>(genreDTOs.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/genres", produces = "application/json", consumes = "application/json")
    ResponseEntity<GenreDTO> saveGenre(@RequestBody GenreDTO genreDTO) {
        GenreDTO genreSaved = this.genreService.saveGenre(genreDTO);
        return new ResponseEntity<>(genreSaved, HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping(value = "/genre/{genreId}")
    ResponseEntity<?> deleteGenre(@PathVariable Long genreId) {
        this.genreService.deleteGenre(genreId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
