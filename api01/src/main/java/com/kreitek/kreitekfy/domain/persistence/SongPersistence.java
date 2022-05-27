package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.domain.entity.Song;

import java.util.List;
import java.util.Optional;

public interface SongPersistence {
    List<Song> getAllSongByGenre(Long songId);

    List<Song> getAllSongById(Long id);
    Optional<Song>getSongById(Long id);
    Song saveSong (Song song);
    void deleteSong(Long id);
}
