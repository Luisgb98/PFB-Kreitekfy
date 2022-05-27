package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.domain.entity.Genre;

import java.util.List;
import java.util.Optional;


public interface GenrePersistence {
    List<Genre> getAllGenres();
    Optional<Genre> getGenreById(Long idGenre);
    Genre saveGenre(Genre genre);
    void deleteGenre(Long idGenre);
}
