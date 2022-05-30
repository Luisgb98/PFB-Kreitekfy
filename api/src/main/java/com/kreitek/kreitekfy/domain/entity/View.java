package com.kreitek.kreitekfy.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "views")
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "viewSequence")
    private Long id;

    @Column
    private Double value;

    @ManyToOne()
    @JoinColumn(name = "song_id", nullable = false)
    private Song song;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public View() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
