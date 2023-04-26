package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieDirectorPairRepository {

    MovieRepository movieRepository = new MovieRepository();

    DirectorRepository directorRepository = new DirectorRepository();

    Map<Director, List<Movie>> pairData = new HashMap<>();
    public boolean addMovieDirectorPair(String movieName, String directorName) {

        Director director = directorRepository.getDirectorByName(directorName);
        if(pairData.containsKey(director)){
            List<Movie> oldList = pairData.get(director);
            oldList.add(movieRepository.getMovieByName(movieName));
            pairData.put(director,oldList);
        }
        else{
            List<Movie> newList = new ArrayList<>();
            newList.add(movieRepository.getMovieByName(movieName));
            pairData.put(director,newList);
        }
        return  true;
    }
    public List<Movie> getMoviesByDirectorName(String directorName){
        Director director = directorRepository.getDirectorByName(directorName);
        return pairData.get(director);
    }

    public boolean deleteSinglePair(Director director){
        pairData.remove(director);
        return true;
    }

    public boolean deleteDirectorByName(String directorName) {
        Director director = directorRepository.getDirectorByName(directorName);
        List<Movie> movieList = pairData.get(director);

        for(Movie movie : movieList){
            boolean isDeletedFromMovieData = movieRepository.deleteMovie(movie);
        }
        boolean isDeletedFromDirectorData = directorRepository.deleteDirector(director);

        boolean isDeletedFromPairData = deleteSinglePair(director);

        return  true;

    }

    public boolean deleteAllDirectors() {

        for(Director director : pairData.keySet()){
            boolean isDeletedDirector = deleteDirectorByName(director.getName());
        }
        return true;
    }
}
