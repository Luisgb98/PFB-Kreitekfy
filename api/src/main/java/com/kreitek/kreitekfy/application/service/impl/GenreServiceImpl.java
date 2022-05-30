package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.GenreDTO;
import com.kreitek.kreitekfy.application.mapper.GenreMapper;
import com.kreitek.kreitekfy.application.service.GenreService;
import com.kreitek.kreitekfy.domain.entity.Genre;
import com.kreitek.kreitekfy.domain.persistence.GenrePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenrePersistence persistence;
    private final GenreMapper mapper;

    @Autowired
    public GenreServiceImpl(GenrePersistence persistence, GenreMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public List<GenreDTO> getAllGenres() {
        List<Genre> genres = this.persistence.getAllGenres();
        return this.mapper.toDto(genres);
    }

    @Override
    public Optional<GenreDTO> getGenreById(Long genreId) {
        return this.persistence.getGenreById(genreId).map(mapper::toDto);
    }

    @Override
    public GenreDTO saveGenre(GenreDTO genreDto) {
        Genre genreSaved = this.persistence.saveGenre(this.mapper.toEntity(genreDto));
        return this.mapper.toDto(genreSaved);
    }

    @Override
    public void deleteGenre(Long genreId) {
        this.persistence.deleteGenre(genreId);
    }
}
