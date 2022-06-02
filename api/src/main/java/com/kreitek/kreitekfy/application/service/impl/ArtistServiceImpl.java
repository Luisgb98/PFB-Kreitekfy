package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.ArtistDTO;
import com.kreitek.kreitekfy.application.mapper.ArtistMapper;
import com.kreitek.kreitekfy.application.service.ArtistService;
import com.kreitek.kreitekfy.domain.entity.Artist;
import com.kreitek.kreitekfy.domain.persistence.ArtistPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistPersistence persistence;
    private final ArtistMapper mapper;

    @Autowired
    public ArtistServiceImpl(ArtistPersistence persistence, ArtistMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public List<ArtistDTO> getAllArtists() {
        List<Artist> artists = this.persistence.getAllArtists();
        return this.mapper.toDto(artists);
    }

    @Override
    public Optional<ArtistDTO> getArtistById(Long artistId) {
        return this.persistence.getArtistById(artistId).map(mapper::toDto);
    }

    @Override
    public ArtistDTO saveArtist(ArtistDTO artistDto) {
        Artist artistSaved = this.persistence.saveArtist(this.mapper.toEntity(artistDto));
        return this.mapper.toDto(artistSaved);
    }

    @Override
    public void deleteArtist(Long artistId) {
        this.persistence.deleteArtist(artistId);
    }
}
