package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.AlbumDTO;
import com.kreitek.kreitekfy.domain.entity.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlbumMapper extends EntityMapper<AlbumDTO, Album>{
    @Override
    @Mapping(source = "songId", target = "song")
    Album toEntity(AlbumDTO dto);

    @Override
    @Mapping(source = "song.id", target = "songId")
    AlbumDTO toDto(Album entity);

    default Album fromId(Long id) {
        if (id == null) return null;
        Album album = new Album();
        album.setId(id);
        return album;
    }
}
