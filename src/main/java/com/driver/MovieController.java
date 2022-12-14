package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService ms;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody() Movie movie) {
        try{
            ms.addMovie(movie);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody() Director director) {
        try {
            ms.addDirector(director);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movie,@RequestParam String directorName) {
        try {
            ms.addMovieAndDirector(movie, directorName);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name) {
        try {
            return new ResponseEntity<>(ms.getMovieByName(name),HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Not present",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name) {
        try {
            return new ResponseEntity<>(ms.getDirectorByName(name),HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Not present",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String director) {
        try {
            return new ResponseEntity<>(ms.getMoviesNameByDirectorName(director),HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Not present",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies() {
        try {
            return new ResponseEntity<>(ms.getAllMovies(),HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Not present",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String director) {
        ms.deleteDirectorAndHisMovie(director);
        return new ResponseEntity("Success",HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors() {
        ms.deleteAllMoviesInMap();
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }
}
