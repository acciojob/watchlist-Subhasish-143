package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository mr;

    public void addMovie(Movie movie) {
        mr.addMovieToMovieList(movie);
    }
    public void addDirector(Director director) {
        mr.addDirectorToDirectorList(director);
    }
    public void addMovieAndDirector(String movie,String director) {
        mr.addToMap(movie,director);
    }
    public Movie getMovieByName(String name) {
        return mr.getMovieByName(name);
    }
    public Director getDirectorByName(String name) {
        return mr.getDirectorByName(name);
    }
    public List<String> getMoviesNameByDirectorName(String director) {
        return mr.getAllMovieByADirector(director);
    }
    public List<String> getAllMovies() {
        return mr.getAllMovie();
    }
    public void deleteDirectorAndHisMovie(String director) {
        mr.deleteDirectorAndHisMovies(director);
    }
    public void deleteAllMoviesInMap() {
        mr.deleteAllTheLinkWithMap();
    }
}
