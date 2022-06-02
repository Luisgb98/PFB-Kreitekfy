package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.GenreDTO;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<GenreDTO> getAllGenres();
    Optional<GenreDTO> getGenreById(Long genreId);
    GenreDTO saveGenre(GenreDTO genreDto);
    void deleteGenre(Long genreId);
}
