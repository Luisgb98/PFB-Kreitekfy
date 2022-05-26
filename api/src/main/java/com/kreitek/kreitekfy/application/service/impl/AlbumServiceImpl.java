package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.AlbumDTO;
import com.kreitek.kreitekfy.application.mapper.AlbumMapper;
import com.kreitek.kreitekfy.application.service.AlbumService;
import com.kreitek.kreitekfy.domain.persistence.AlbumPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumPersistence persistence;
    private final AlbumMapper mapper;

    @Autowired
    public AlbumServiceImpl(AlbumPersistence persistence, AlbumMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public List<AlbumDTO> getAllAlbums() {
        return null;
    }

    @Override
    public Optional<AlbumDTO> getAlbumById(Long albumId) {
        return Optional.empty();
    }

    @Override
    public AlbumDTO saveAlbum(AlbumDTO albumDto) {
        return null;
    }

    @Override
    public void deleteAlbum(Long albumId) {

    }
}
