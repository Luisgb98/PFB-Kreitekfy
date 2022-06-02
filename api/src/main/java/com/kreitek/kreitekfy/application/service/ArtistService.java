package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.ArtistDTO;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<ArtistDTO> getAllArtists();
    Optional<ArtistDTO> getArtistById(Long artistId);
    ArtistDTO saveArtist(ArtistDTO artistDto);
    void deleteArtist(Long artistId);
}
