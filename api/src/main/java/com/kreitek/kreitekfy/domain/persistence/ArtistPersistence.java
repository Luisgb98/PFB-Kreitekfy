package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.domain.entity.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistPersistence {
    List<Artist> getAllArtists();
    Optional<Artist> getArtistById(Long artistId);
    Artist saveArtist(Artist artist);
    void deleteArtist(Long artistId);
}
