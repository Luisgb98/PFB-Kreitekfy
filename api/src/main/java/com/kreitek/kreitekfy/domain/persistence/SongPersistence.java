package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.domain.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SongPersistence {
    List<Song> getAllSongs();
    List<Song> getAllSongsByArtist(Long artistId);
    List<Song> getAllSongsByAlbum(Long albumId);
    List<Song> getAllSongsByGenre(Long genreId);
    Optional<Song>getSongById(Long songId);
    Song saveSong (Song song);
    void deleteSong(Long songId);
    Page<Song> findAll(Pageable pageable, String filter);
}
