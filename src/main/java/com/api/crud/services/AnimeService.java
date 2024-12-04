package com.api.crud.services;


import com.api.crud.models.AnimeModel;
import com.api.crud.repositories.IAnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {
    @Autowired
    IAnimeRepository animeRepository;

    // Create
    public AnimeModel saveAnime(AnimeModel anime){
        return animeRepository.save(anime);
    }

    // Read
    public List<AnimeModel> getAnimes(){
        return animeRepository.findAll();
    }

    public Optional<AnimeModel> getById(Long id){
        return animeRepository.findById(id);
    }

    // Update
    public Optional<AnimeModel> updateById(AnimeModel toUpdate, Long id) {
        Optional<AnimeModel> animeOptional = animeRepository.findById(id);

        if (animeOptional.isPresent()) {
            AnimeModel anime = animeOptional.get();
            anime.setName(toUpdate.getName());
            anime.setDescription(toUpdate.getDescription());
            anime.setScore(toUpdate.getScore());
            animeRepository.save(anime);
            return Optional.of(anime);
        }

        return Optional.empty();
    }

    // Delete
    public boolean deleteById(Long id) {
        if (animeRepository.existsById(id)) {
            animeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
