package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.AlbumDTO;
import com.kreitek.kreitekfy.application.mapper.AlbumMapper;
import com.kreitek.kreitekfy.application.service.AlbumService;
import com.kreitek.kreitekfy.domain.entity.Album;
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
        List<Album> albums = this.persistence.getAllAlbums();
        return this.mapper.toDto(albums);
    }

    @Override
    public Optional<AlbumDTO> getAlbumById(Long albumId) {
        return this.persistence.getAlbumById(albumId).map(mapper::toDto);
    }

    @Override
    public AlbumDTO saveAlbum(AlbumDTO albumDto) {
        Album album = this.persistence.saveAlbum(this.mapper.toEntity(albumDto));
        return this.mapper.toDto(album);
    }

    @Override
    public void deleteAlbum(Long albumId) {
        
    }
}
