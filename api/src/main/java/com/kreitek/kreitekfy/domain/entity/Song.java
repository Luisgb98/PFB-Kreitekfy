package com.kreitek.kreitekfy.domain.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "songSequence")
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column
    private Long length;
    @Lob
    private byte[] image;
    @Column
    private Date release_date;
    @Column
    private double assessment;
    @Column
    private Long playback;

    @ManyToOne()
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @ManyToOne()
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @ManyToOne()
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    public Song() {
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

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public double getAssessment() {
        return assessment;
    }

    public void setAssessment(double assessment) {
        this.assessment = assessment;
    }

    public Long getPlayback() {
        return playback;
    }

    public void setPlayback(Long playback) {
        this.playback = playback;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
