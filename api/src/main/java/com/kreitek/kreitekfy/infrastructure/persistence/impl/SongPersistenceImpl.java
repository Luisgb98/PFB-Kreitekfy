package com.kreitek.kreitekfy.infrastructure.persistence.impl;

import com.kreitek.kreitekfy.domain.entity.Song;
import com.kreitek.kreitekfy.domain.persistence.SongPersistence;
import com.kreitek.kreitekfy.infrastructure.persistence.SongRepository;
import com.kreitek.kreitekfy.infrastructure.specs.SongSpecification;
import com.kreitek.kreitekfy.infrastructure.specs.shared.SearchCriteriaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SongPersistenceImpl implements SongPersistence {

    private final SongRepository songRepository;

    @Autowired
    public SongPersistenceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> getAllSongs() {
        return this.songRepository.findAll();
    }

    @Override
    public List<Song> getAllSongsByArtist(Long artistId) {
        return this.songRepository.findAllByArtistId(artistId);
    }

    @Override
    public List<Song> getAllSongsByAlbum(Long albumId) {
        return this.songRepository.findAllByAlbumId(albumId);
    }

    @Override
    public List<Song> getAllSongsByGenre(Long genreId) {
        return this.songRepository.findAllByGenreId(genreId);
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
    public void deleteSong(Long songId) {
        this.songRepository.deleteById(songId);
    }

    @Override
    public Page<Song> findAll(Pageable pageable, String filters) {
        SongSpecification specification = new SongSpecification(SearchCriteriaHelper.fromFilterString(filters));
        return this.songRepository.findAll(specification, pageable);
    }
}
