package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.RatingDTO;

import java.util.List;

public interface RatingService {
    List<RatingDTO> getAllRatings();
    List<RatingDTO> getRatingsBySongId(Long songId);
    RatingDTO saveRating(RatingDTO ratingDto);
    void deleteRating(Long ratingId);
}
