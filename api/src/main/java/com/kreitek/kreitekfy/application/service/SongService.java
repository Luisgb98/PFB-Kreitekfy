package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.SongDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<SongDTO> getAllSongs();
    List<SongDTO> getAllSongsByArtist(Long artistId);
    List<SongDTO> getAllSongsByAlbum(Long albumId);
    List<SongDTO> getAllSongsByGenre(Long genreId);
    Optional<SongDTO> getSongById(Long songId);
    SongDTO saveSong (SongDTO songDto);
    void deleteSong(Long songId);
    Page<SongDTO> getSongsByCriteriaStringPaged(Pageable pageable, String filter);
}
