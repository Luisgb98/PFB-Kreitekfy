package com.kreitek.kreitekfy.infrastructure.persistence;

import com.kreitek.kreitekfy.domain.entity.Song;
import com.kreitek.kreitekfy.domain.persistence.SongPersistence;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SongPersistenceImpl implements SongPersistence {
    private final SongRepository songRepository;

    @Autowired
    public SongPersistenceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> getAllSongByGenre(Long songId) {
        return this.songRepository.findAllByGenreId(songId);
    }

    @Override
    public List<Song> getAllSongById(Long id) {
        return this.songRepository.findAllById(id);
    }

    @Override
    public Optional<Song> getSongById(Long songId) {
        return this.songRepository.findById(songId);
    }

    @Override
    public Song saveSong(Song song) {
        return this.songRepository.save(song);
    }

    @Override
    public void deleteSong(Long id) {
    this.songRepository.deleteById(id);
    }
}
