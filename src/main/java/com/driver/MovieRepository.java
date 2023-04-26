package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRepository {

    Map<String,Movie> movieData = new HashMap<>();

    //My watchlist that aren’t mapped to any of the director.

    Movie movie1 = new Movie("Raazi",138,7.7);
    Movie movie2 = new Movie("Barfi",151,8.1);
    Movie movie3 = new Movie("Queen",146,9.1);

    public boolean addMovie(Movie movie) {
        movieData.put(movie.getName(), movie);
        return  true;
    }

    public Movie getMovieByName(String name) {
        return movieData.get(name);
    }

    public List<String> getAllMovies() {
        List<String> moviesList = new ArrayList<>(movieData.keySet());
        return moviesList;
    }
    public boolean deleteMovie(Movie movie){
        movieData.remove(movie);
        return true;
    }
}
