package domainmodel;

import java.util.Comparator;

public class GenreComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie movie1, Movie movie2){
        return movie1.getDirector().compareToIgnoreCase(movie2.getGenre());
    }



}
