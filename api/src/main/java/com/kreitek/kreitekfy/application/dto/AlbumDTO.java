package com.kreitek.kreitekfy.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AlbumDTO {
    private Long id;
    private String album_name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date release_date;
    private byte[] image;

    public AlbumDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
