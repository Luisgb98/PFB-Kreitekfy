package com.kreitek.kreitekfy.infrastructure.persistence;


import com.kreitek.kreitekfy.domain.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
