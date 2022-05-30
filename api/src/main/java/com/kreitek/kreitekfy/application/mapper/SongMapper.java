package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.SongDTO;
import com.kreitek.kreitekfy.domain.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { GenreMapper.class, ArtistMapper.class, AlbumMapper.class, RatingMapper.class, ViewMapper.class })
public interface SongMapper extends EntityMapper<SongDTO, Song> {

    @Override
    @Mapping(source = "genreId", target = "genre")
    @Mapping(source = "artistId", target = "artist")
    @Mapping(source = "albumId", target = "album")
    @Mapping(source = "ratingId", target = "rating")
    @Mapping(source = "viewsId", target = "view")
    Song toEntity(SongDTO dto);

    @Override
    @Mapping(source = "genre.id", target = "genreId")
    @Mapping(source = "genre.name", target = "genreName")
    @Mapping(source = "artist.id", target = "artistId")
    @Mapping(source = "artist.name", target = "artistName")
    @Mapping(source = "album.id", target = "albumId")
    @Mapping(source = "album.name", target = "albumName")
    @Mapping(source = "album.image", target = "albumImage")
    @Mapping(source = "rating.id", target = "ratingId")
    @Mapping(source = "rating.value", target = "ratingValue")
    @Mapping(source = "view.id", target = "viewsId")
    @Mapping(source = "view.value", target = "viewsValue")
    SongDTO toDto(Song entity);

    default Song fromId(Long id) {
        if (id == null) return null;
        Song song = new Song();
        song.setId(id);
        return song;
    }
}
