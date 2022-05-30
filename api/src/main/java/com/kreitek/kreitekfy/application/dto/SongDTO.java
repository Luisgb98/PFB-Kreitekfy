package com.kreitek.kreitekfy.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kreitek.kreitekfy.domain.entity.Genre;

import java.io.Serializable;
import java.sql.Date;

public class SongDTO implements Serializable {

    private Long id;

    private String name;

    private Genre genre;

    private Long length;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date release_date;

    private Long genreId;
    private String genreName;

    private Long artistId;
    private String artistName;

    private Long albumId;
    private String albumName;
    private byte[] albumImage;

    private Long ratingId;
    private double ratingValue;

    private Long viewsId;
    private Long viewsValue;

    public SongDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public byte[] getAlbumImage() {
        return albumImage;
    }

    public void setAlbumImage(byte[] albumImage) {
        this.albumImage = albumImage;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public double getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(double ratingValue) {
        this.ratingValue = ratingValue;
    }

    public Long getViewsId() {
        return viewsId;
    }

    public void setViewsId(Long viewsId) {
        this.viewsId = viewsId;
    }

    public Long getViewsValue() {
        return viewsValue;
    }

    public void setViewsValue(Long viewsValue) {
        this.viewsValue = viewsValue;
    }
}