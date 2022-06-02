package com.kreitek.kreitekfy.infrastructure.persistence.impl;

import com.kreitek.kreitekfy.domain.entity.View;
import com.kreitek.kreitekfy.domain.persistence.ViewPersistence;
import com.kreitek.kreitekfy.infrastructure.persistence.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ViewPersistenceImpl implements ViewPersistence {

    private final ViewRepository viewRepository;

    @Autowired
    public ViewPersistenceImpl(ViewRepository viewRepository) {
        this.viewRepository = viewRepository;
    }

    @Override
    public List<View> getAllViews() {
        return this.viewRepository.findAll();
    }

    @Override
    public List<View> getViewsBySongId(Long songId) {
        return this.viewRepository.findAllBySongId(songId);
    }

    @Override
    public View saveView(View view) {
        return this.viewRepository.save(view);
    }

    @Override
    public void deleteView(Long viewId) {
        this.viewRepository.deleteById(viewId);
    }
}
