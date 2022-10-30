package com.driver;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MovieRepository {
    Set<Movie> movieList = new HashSet<>();
    Map<Director,List<String>> directorsList = new HashMap<>();// <director , movie name>

    void addMovieToMovieList(Movie movie) {
        movieList.add(movie);
    }
    void addDirectorToDirectorList(Director director) {
        directorsList.put(director,new ArrayList<>());
    }
    void addToMap(String movie,String director) {
        for(Director d : directorsList.keySet()) {
            if (d.getName().equals(director)) {
                List<String>listMovie = directorsList.get(d);
                listMovie.add(movie);
                directorsList.put(d,listMovie);
            }
        }
    }
    List<String> getAllMovie() {
        List<String> moviesToWatch = new ArrayList<>();
        for(Movie m : movieList) {
            moviesToWatch.add(m.getName());
        }
        return moviesToWatch;
    }
    List<String> getAllMovieByADirector(String name) {
        for(Director d : directorsList.keySet()) {
            if (d.getName().equals(name)) {
                return directorsList.get(d);
            }
        }
        return new ArrayList<>();
    }
    void deleteAllTheLinkWithMap() {
        for(Director d : directorsList.keySet()) {
            for(String name : directorsList.get(d)) {
                movieList.removeIf(m -> m.getName().equals(name));
            }
        }
        directorsList.clear();
    }
    void deleteDirectorAndHisMovies(String name) {
        for(Director d : directorsList.keySet()) {
            if (d.getName().equals(name)) {
                for (String movie : directorsList.get(d)) {
                    for(Movie m: movieList) {
                        if (movie.equals(m.getName())) {
                            movieList.remove(m);
                        }
                    }
                }
                directorsList.remove(d);
            }
        }
    }
    Movie getMovieByName(String name) {
        for(Movie m: movieList) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }
    Director getDirectorByName(String Name) {
        for(Director d:directorsList.keySet()) {
            if (d.getName().equals(Name)) {
                return d;
            }
        }
        return null;
    }
}
