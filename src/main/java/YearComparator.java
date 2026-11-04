import domainmodel.Movie;

import java.util.Comparator;

public class YearComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie movie1, Movie movie2){
        return Integer.compare(movie1.getYearCreated(), movie2.getYearCreated());
    }
}
