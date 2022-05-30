package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.SongDTO;
import com.kreitek.kreitekfy.application.mapper.SongMapper;
import com.kreitek.kreitekfy.application.service.SongService;
import com.kreitek.kreitekfy.domain.entity.Song;
import com.kreitek.kreitekfy.domain.persistence.SongPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    private final SongPersistence persistence;
    private final SongMapper mapper;

    @Autowired
    public SongServiceImpl(SongPersistence persistence, SongMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public List<SongDTO> getAllSongs() {
        List<Song> songs = this.persistence.getAllSongs();
        return this.mapper.toDto(songs);
    }

    @Override
    public List<SongDTO> getAllSongsByArtist(Long artistId) {
        List<Song> songs = this.persistence.getAllSongsByArtist(artistId);
        return this.mapper.toDto(songs);
    }

    @Override
    public List<SongDTO> getAllSongsByAlbum(Long albumId) {
        List<Song> songs = this.persistence.getAllSongsByAlbum(albumId);
        return this.mapper.toDto(songs);
    }

    @Override
    public List<SongDTO> getAllSongsByGenre(Long genreId) {
        List<Song> songs = this.persistence.getAllSongsByGenre(genreId);
        return this.mapper.toDto(songs);
    }

    @Override
    public Optional<SongDTO> getSongById(Long songId) {
        return this.persistence.getSongById(songId).map(mapper::toDto);
    }

    @Override
    public SongDTO saveSong(SongDTO songDto) {
        Song songSaved = this.persistence.saveSong(this.mapper.toEntity(songDto));
        return this.mapper.toDto(songSaved);
    }

    @Override
    public void deleteSong(Long songId) {
        this.persistence.deleteSong(songId);
    }

    @Override
    public Page<SongDTO> getSongsByCriteriaStringPaged(Pageable pageable, String filter) {
        Page<Song> songPage = this.persistence.findAll(pageable, filter);
        return songPage.map(mapper::toDto);
    }
}
