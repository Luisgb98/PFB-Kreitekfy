package com.kreitek.kreitekfy.application.dto;

import java.io.Serializable;

public class GenreDTO implements Serializable {

    private Long id;
    private String music_genre;

    public GenreDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusic_genre() {
        return music_genre;
    }

    public void setMusic_genre(String music_genre) {
        this.music_genre = music_genre;
    }
}
