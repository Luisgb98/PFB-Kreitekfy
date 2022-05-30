package com.kreitek.kreitekfy.infrastructure.rest;

import com.kreitek.kreitekfy.application.dto.RatingDTO;
import com.kreitek.kreitekfy.application.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingRestController {

    private final RatingService ratingService;

    @Autowired
    public RatingRestController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @CrossOrigin
    @GetMapping(value = "/ratings", produces = "application/json")
    ResponseEntity<List<RatingDTO>> getAllRatings() {
        List<RatingDTO> ratingDTOS = this.ratingService.getAllRatings();
        return new ResponseEntity<>(ratingDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/song/{songId}/ratings", produces = "application/json")
    ResponseEntity<List<RatingDTO>> getRatingsBySongId(@PathVariable Long songId) {
        List<RatingDTO> ratingDTOS = this.ratingService.getRatingsBySongId(songId);
        return new ResponseEntity<>(ratingDTOS, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/ratings", produces = "application/json", consumes = "application/json")
    ResponseEntity<RatingDTO> saveRating(@RequestBody RatingDTO ratingDTO) {
        RatingDTO ratingSaved = this.ratingService.saveRating(ratingDTO);
        return new ResponseEntity<>(ratingSaved, HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping(value = "/rating/{ratingId}")
    ResponseEntity<?> deleteRating(@PathVariable Long ratingId) {
        this.ratingService.deleteRating(ratingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
