package com.driver;

import java.util.List;

public class MovieService {

    MovieRepository movieRepository = new MovieRepository();

    public boolean addMovie(Movie movie){
        boolean added = movieRepository.addMovie(movie);
        return true;
    }

    public Movie getMovieByName(String name) {
        Movie movie = movieRepository.getMovieByName(name);
        return movie;
    }

    public List<String> getAllMovies() {
        List<String> moviesList = movieRepository.getAllMovies();
        return moviesList;
    }
}
