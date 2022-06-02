package com.kreitek.kreitekfy.infrastructure.persistence;

import com.kreitek.kreitekfy.domain.entity.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ViewRepository extends JpaRepository<View, Long>, JpaSpecificationExecutor<View> {
    List<View> findAllBySongId(Long id);
}
