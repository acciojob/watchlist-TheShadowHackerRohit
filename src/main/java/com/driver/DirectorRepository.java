package com.driver;

import java.util.HashMap;
import java.util.Map;

public class DirectorRepository {

    Map<String,Director> directorData = new HashMap<>();

    public boolean addDirector(Director director) {
        directorData.put(director.getName(), director);
        return true;
    }

    public Director getDirectorByName(String name) {
        Director director = directorData.get(name);
        return director;
    }

    public boolean deleteDirector(Director director){
        directorData.remove(director);
        return true;
    }
}
