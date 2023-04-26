package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    MovieService movieService = new MovieService();

    DirectorService directorService = new DirectorService();

    MovieDirectorPairService movieDirectorPairService = new MovieDirectorPairService();



    //1=======================================================================
    /*
    Add a movie: POST /movies/add-movie
    Pass the Movie object as request body
    Return success message wrapped in a ResponseEntity object
    Controller Name - addMovie
     */

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
            boolean added = movieService.addMovie(movie);
            return new ResponseEntity("movie added successful", HttpStatus.CREATED);
    }

    //2==============================================================================
       /* Add a director: POST /movies/add-director
    Pass the Director object as request body
    Return success message wrapped in a ResponseEntity object
    Controller Name - addDirector
    */

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        boolean added = directorService.addDirector(director);
        return new ResponseEntity("Director added successful", HttpStatus.CREATED);
    }



    //3====================================================================================
     /*
    Pair an existing movie and director: PUT /movies/add-movie-director-pair
    Pass movie name and director name as request parameters
    Return success message wrapped in a ResponseEntity object
    Controller Name - addMovieDirectorPair
     */

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movieName, @RequestParam String directorName){
        boolean isGetPaired = movieDirectorPairService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity("Update pair successful", HttpStatus.CREATED);
    }

    //4====================================================================================
    /*
   Get Movie by movie name: GET /movies/get-movie-by-name/{name}
   Pass movie name as path parameter
   Return Movie object wrapped in a ResponseEntity object
   Controller Name - getMovieByName
    */

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){

        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity(movie,HttpStatus.OK);
    }

    //5====================================================================================
    /*
   Get Director by director name: GET /movies/get-director-by-name/{name}
   Pass director name as path parameter
   Return Director object wrapped in a ResponseEntity object
   Controller Name - getDirectorByName
    */

   @GetMapping("/get-director-by-name/{name}")
   public ResponseEntity getDirectorByName(@PathVariable String name){

       Director director = directorService.getDirectorByName(name);
       return new ResponseEntity(director,HttpStatus.OK);
   }


   //6====================================================================================
/*
    Get List of movies name for a given director name: GET /movies/get-movies-by-director-name/{director}
    Pass director name as path parameter
    Return List of movies name(List()) wrapped in a ResponseEntity object
    Controller Name - getMoviesByDirectorName
 */

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String director){
        List<String> moviesName = movieDirectorPairService.getMoviesByDirectorName(director);
        return  new ResponseEntity(moviesName,HttpStatus.OK);
    }

    //7====================================================================================
    /*
    Get List of all movies added: GET /movies/get-all-movies
    No params or body required
    Return List of movies name(List()) wrapped in a ResponseEntity object
    Controller Name - findAllMovies
     */

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> moviesList = movieService.getAllMovies();
        return  new ResponseEntity(moviesList,HttpStatus.OK);
    }

    //8====================================================================================
    /*
    Delete a director and its movies from the records: DELETE /movies/delete-director-by-name
    Pass director’s name as request parameter
    Return success message wrapped in a ResponseEntity object
    Controller Name - deleteDirectorByName
     */

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String directorName){
        boolean isDeletedDirector = movieDirectorPairService.deleteDirectorByName(directorName);
        return  new ResponseEntity("Delete a director and its movies from the records",HttpStatus.OK);
    }


    //9====================================================================================
    /*
    Delete all directors and all movies by them from the records: DELETE /movies/delete-all-directors
    No params or body required
    Return success message wrapped in a ResponseEntity object
    Controller Name - deleteAllDirectors
     */
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        boolean isDeleteAllRecords = movieDirectorPairService.deleteAllDirectors();
        return new ResponseEntity("Delete all directors and all movies by them from the records",HttpStatus.OK);
    }



    /*
            (Note that there can be some movies on your watchlist that aren’t mapped to any of the director.
             Make sure you do not remove them.)
     */


}
