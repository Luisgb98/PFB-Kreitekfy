package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.ViewDTO;
import com.kreitek.kreitekfy.application.mapper.ViewMapper;
import com.kreitek.kreitekfy.application.service.ViewService;
import com.kreitek.kreitekfy.domain.entity.View;
import com.kreitek.kreitekfy.domain.persistence.ViewPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewServiceImpl implements ViewService {

    private final ViewPersistence persistence;
    private final ViewMapper mapper;

    @Autowired
    public ViewServiceImpl(ViewPersistence persistence, ViewMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public List<ViewDTO> getAllViews() {
        List<View> views = this.persistence.getAllViews();
        return this.mapper.toDto(views);
    }

    @Override
    public List<ViewDTO> getViewsBySongId(Long songId) {
        List<View> views = this.persistence.getViewsBySongId(songId);
        return this.mapper.toDto(views);
    }

    @Override
    public ViewDTO saveView(ViewDTO viewDto) {
        View viewSaved = this.persistence.saveView(this.mapper.toEntity(viewDto));
        return this.mapper.toDto(viewSaved);
    }

    @Override
    public void deleteView(Long viewId) {
        this.persistence.deleteView(viewId);
    }
}
