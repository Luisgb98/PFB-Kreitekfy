package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.SongDTO;
import com.kreitek.kreitekfy.domain.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = GenreMapper.class)
public interface SongMapper extends EntityMapper<SongDTO, Song> {

    @Override
    @Mapping(source = "genreId", target = "genre")
    Song toEntity(SongDTO dto);

    @Override
    @Mapping(source = "genre.id", target = "genreId")
    @Mapping(source = "genre.name", target = "genreName")
    SongDTO toDto(Song entity);
}
