package com.driver;

public class DirectorService {



    DirectorRepository directorRepository = new DirectorRepository();

    public boolean addDirector(Director director) {
        boolean isAdd = directorRepository.addDirector(director);
        return true;
    }

    public Director getDirectorByName(String name) {
        Director director = directorRepository.getDirectorByName(name);
        return director;
    }
}
