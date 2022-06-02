package com.kreitek.kreitekfy.application.dto;

import java.io.Serializable;

public class ViewDTO implements Serializable {
    private Long id;
    private Double value;
    private Long songId;
    private Long userId;

    public ViewDTO() {
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

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
