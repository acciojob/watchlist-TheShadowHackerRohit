package com.driver;

import java.util.ArrayList;
import java.util.List;

public class MovieDirectorPairService {

    MovieDirectorPairRepository movieDirectorPairRepository = new MovieDirectorPairRepository();

    public boolean addMovieDirectorPair(String movieName, String directorName) {
        boolean isGetPaired = movieDirectorPairRepository.addMovieDirectorPair(movieName,directorName);
        return  isGetPaired;
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        List<Movie> moviesList = movieDirectorPairRepository.getMoviesByDirectorName(directorName);
        List<String> movieListName = new ArrayList<>();
        for(Movie movie : moviesList){
            movieListName.add(movie.getName());
        }
        return movieListName;
    }

    public boolean deleteDirectorByName(String directorName) {
        boolean isDeletedDirector = movieDirectorPairRepository.deleteDirectorByName(directorName);
        return true;
    }

    public boolean deleteAllDirectors() {
        boolean isDeleteAllRecords = movieDirectorPairRepository.deleteAllDirectors();
        return true;
    }
}
