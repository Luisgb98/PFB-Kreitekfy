package com.kreitek.kreitekfy.infrastructure.persistence.impl;

import com.kreitek.kreitekfy.domain.entity.Rating;
import com.kreitek.kreitekfy.domain.persistence.RatingPersistence;
import com.kreitek.kreitekfy.infrastructure.persistence.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RatingPersistenceImpl implements RatingPersistence {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingPersistenceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public List<Rating> getAllRatings() {
        return this.ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsBySongId(Long songId) {
        return this.ratingRepository.findAllBySongId(songId);
    }

    @Override
    public Rating saveRating(Rating rating) {
        return this.ratingRepository.save(rating);
    }

    @Override
    public void deleteRating(Long ratingId) {
        this.ratingRepository.deleteById(ratingId);
    }
}
