package domainmodel;

import java.util.Comparator;

public class LengthComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie movie1, Movie movie2) {
        return Integer.compare(movie1.getLengthInMinutes(), movie2.getLengthInMinutes());
    }
}