package com.kreitek.kreitekfy.domain.persistence;

import com.kreitek.kreitekfy.domain.entity.View;

import java.util.List;

public interface ViewPersistence {
    List<View> getAllViews();
    List<View> getViewsBySongId(Long songId);
    View saveView(View view);
    void deleteView(Long viewId);
}
