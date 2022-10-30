package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository mr;

    void addMovie(Movie movie) {
        mr.addMovieToMovieList(movie);
    }
    void addDirector(Director director) {
        mr.addDirectorToDirectorList(director);
    }
    void addMovieAndDirector(String movie,String director) {
        mr.addToMap(movie,director);
    }
    Movie getMovieByName(String name) {
        return mr.getMovieByName(name);
    }
    Director getDirectorByName(String name) {
        return mr.getDirectorByName(name);
    }
    List<String> getMoviesNameByDirectorName(String director) {
        return mr.getAllMovieByADirector(director);
    }
    List<String> getAllMovies() {
        return mr.getAllMovie();
    }
    void deleteDirectorAndHisMovie(String director) {
        mr.deleteDirectorAndHisMovies(director);
    }
    void deleteAllMoviesInMap() {
        mr.deleteAllTheLinkWithMap();
    }
}
