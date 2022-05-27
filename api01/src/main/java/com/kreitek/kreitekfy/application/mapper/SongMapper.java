package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.SongDTO;
import com.kreitek.kreitekfy.domain.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SongMapper extends EntityMapper<SongDTO, Song> {

    @Override
    @Mapping(source = "genreId", target = "genre")
    Song toEntity(SongDTO dto);

    @Override
    @Mapping(source = "genreId", target = "genreId")
    @Mapping(source = "music_genre", target = "music_genre")
    SongDTO toDto(Song entity);
}
