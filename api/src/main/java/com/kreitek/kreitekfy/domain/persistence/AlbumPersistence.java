package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.domain.entity.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumPersistence {
    List<Album> getAllAlbums();
    Optional<Album> getAlbumById(Long albumId);
    Album saveAlbum(Album album);
    void deleteAlbum(Long albumId);
}
