package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.ViewDTO;
import com.kreitek.kreitekfy.domain.entity.View;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { SongMapper.class, UserMapper.class })
public interface ViewMapper extends EntityMapper<ViewDTO, View> {

    @Override
    @Mapping(source = "songId", target = "song")
    @Mapping(source = "userId", target = "user")
    View toEntity(ViewDTO dto);

    @Override
    @Mapping(source = "song.id", target = "songId")
    @Mapping(source = "user.id", target = "userId")
    ViewDTO toDto(View entity);

    default View fromId(Long id) {
        if (id == null) return null;
        View view = new View();
        view.setId(id);
        return view;
    }
}
