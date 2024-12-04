package com.api.crud.repositories;

import com.api.crud.models.AnimeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnimeRepository extends JpaRepository<AnimeModel, Long> {
}
