package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.ArtistDTO;
import com.kreitek.kreitekfy.domain.entity.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArtistMapper extends EntityMapper<ArtistDTO, Artist>{

    @Override
    @Mapping(source = "albumId", target = "album")
    @Mapping(source = "songId", target = "song")
    Artist toEntity(ArtistDTO dto);

    @Override
    @Mapping(source = "album.id", target = "albumId")
    @Mapping(source = "song.id", target = "songId")
    ArtistDTO toDto(Artist entity);

    default Artist fromId(Long id) {
        if (id == null) return null;
        Artist artist = new Artist();
        artist.setId(id);
        return artist;
    }
}
