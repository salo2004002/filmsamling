import java.util.ArrayList;

public class Controller {
    MovieCollection movieCollection = new MovieCollection();

    public void addMovie(String title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre) {
    }

    public ArrayList<Movie> getMovies() {
        return movieCollection.getMovies();
    }

    public int getNumberOfMovies() {
        return movieCollection.getNumberOfMovies();
    }

    public ArrayList<Movie> searchMovies(String searchText) {
        return movieCollection.searchMovies(searchText);
    }

    public boolean editMovie(Movie movie, String title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre) {
        return movieCollection.editMovie(movie, title, director, yearCreated, inColor, lengthInMinutes, genre );
    }

    public boolean deleteMovie(Movie movie) {
        return movieCollection.deleteMovie(movie);
    }
}
