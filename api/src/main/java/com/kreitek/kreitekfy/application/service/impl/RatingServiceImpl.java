package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.RatingDTO;
import com.kreitek.kreitekfy.application.mapper.RatingMapper;
import com.kreitek.kreitekfy.application.service.RatingService;
import com.kreitek.kreitekfy.domain.entity.Rating;
import com.kreitek.kreitekfy.domain.persistence.RatingPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingPersistence persistence;
    private final RatingMapper mapper;

    @Autowired
    public RatingServiceImpl(RatingPersistence persistence, RatingMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public List<RatingDTO> getAllRatings() {
        List<Rating> ratings = this.persistence.getAllRatings();
        return this.mapper.toDto(ratings);
    }

    @Override
    public List<RatingDTO> getRatingsBySongId(Long songId) {
        List<Rating> ratings = this.persistence.getRatingsBySongId(songId);
        return this.mapper.toDto(ratings);
    }

    @Override
    public RatingDTO saveRating(RatingDTO ratingDto) {
        Rating ratingSaved = this.persistence.saveRating(this.mapper.toEntity(ratingDto));
        return this.mapper.toDto(ratingSaved);
    }

    @Override
    public void deleteRating(Long ratingId) {
        this.persistence.deleteRating(ratingId);
    }
}
