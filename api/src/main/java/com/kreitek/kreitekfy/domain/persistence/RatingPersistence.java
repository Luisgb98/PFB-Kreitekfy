package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.domain.entity.Rating;

import java.util.List;

public interface RatingPersistence {
    List<Rating> getAllRatings();
    List<Rating> getRatingsBySongId(Long songId);
    Rating saveRating(Rating rating);
    void deleteRating(Long ratingId);
}
