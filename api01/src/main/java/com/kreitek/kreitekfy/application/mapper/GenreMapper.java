package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.GenreDTO;
import com.kreitek.kreitekfy.domain.entity.Genre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper extends EntityMapper<GenreDTO, Genre> {
    default Genre fromId(Long id){

        if (id == null) return null;

        Genre genre = new Genre();
        genre.setId(id);
        return genre;
    }
}
