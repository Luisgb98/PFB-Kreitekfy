package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.RatingDTO;
import com.kreitek.kreitekfy.domain.entity.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { SongMapper.class, UserMapper.class })
public interface RatingMapper extends EntityMapper<RatingDTO, Rating> {

    @Override
    @Mapping(source = "songId", target = "song")
    @Mapping(source = "userId", target = "user")
    Rating toEntity(RatingDTO dto);

    @Override
    @Mapping(source = "song.id", target = "songId")
    @Mapping(source = "user.id", target = "userId")
    RatingDTO toDto(Rating entity);

    default Rating fromId(Long id) {
        if (id == null) return null;
        Rating rating = new Rating();
        rating.setId(id);
        return rating;
    }
}
