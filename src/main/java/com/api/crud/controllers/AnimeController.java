package com.api.crud.controllers;


import com.api.crud.models.AnimeModel;
import com.api.crud.services.AnimeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/anime")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    // Create
    @PostMapping
    public AnimeModel saveUser(@Valid @RequestBody AnimeModel anime){
        return this.animeService.saveAnime(anime);
    }

    // Read
    @GetMapping
    public List<AnimeModel> getAnimes(){
        return this.animeService.getAnimes();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        Optional<AnimeModel> anime = this.animeService.getById(id);
        if(anime.isPresent()){
            return ResponseEntity.ok(anime.get());
        } else{
            return ResponseEntity.status(404).body("El anime con ID: " + id + " no fue encontrado.");
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody AnimeModel toUpdate) {
        Optional<AnimeModel> updatedAnime = animeService.updateById(toUpdate, id);

        if (updatedAnime.isPresent()) {
            return ResponseEntity.ok(updatedAnime.get());
        } else {
            return ResponseEntity.status(404).body("El anime con ID: " + id + " no fue encontrado.");
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        boolean deleted = animeService.deleteById(id);
        if (deleted) {
            return ResponseEntity.ok("El anime con ID: " + id + " fue eliminado.");
        } else {
            return ResponseEntity.status(404).body("El anime con ID: " + id + " no fue encontrado.");
        }
    }
}
