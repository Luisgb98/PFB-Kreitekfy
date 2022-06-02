package com.kreitek.kreitekfy.infrastructure.persistence.impl;

import com.kreitek.kreitekfy.application.mapper.GenreMapper;
import com.kreitek.kreitekfy.domain.entity.Genre;
import com.kreitek.kreitekfy.domain.persistence.GenrePersistence;
import com.kreitek.kreitekfy.infrastructure.persistence.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GenrePersistenceImpl implements GenrePersistence {
    private final GenreRepository genreRepository;

    @Autowired
    public GenrePersistenceImpl(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;

    }

    @Override
    public List<Genre> getAllGenres() {
       return this.genreRepository.findAll();
    }

    @Override
    public Optional<Genre> getGenreById(Long genreId) {
        return this.genreRepository.findById(genreId);
    }

    @Override
    public Genre saveGenre(Genre genre) {
        return this.genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(Long genreId) {
        this.genreRepository.deleteById(genreId);

    }
}
