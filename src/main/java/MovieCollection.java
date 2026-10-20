import java.util.ArrayList;

public class MovieCollection {

    private ArrayList<Movie> movies;


    public MovieCollection() {
        movies = new ArrayList<>();
    }

    public void addMovie(String title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre) {


    }

    public ArrayList<Movie> getMovies() {
        return null;
    }

    public int getNumberOfMovies() {
        return 0;
    }

    public ArrayList<Movie> searchMovies(String searchText) {
        return null;
    }

    public boolean editMovie(Movie movie, String title, String director, int yearCreated,
                             boolean inColor, int lengthInMinutes, String genre) {
        return false;
    }

    public boolean deleteMovie(Movie movie) {
        return false;
    }
}