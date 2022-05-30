package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.ViewDTO;

import java.util.List;

public interface ViewService {
    List<ViewDTO> getAllViews();
    List<ViewDTO> getViewsBySongId(Long songId);
    ViewDTO saveView(ViewDTO viewDto);
    void deleteView(Long viewId);
}
