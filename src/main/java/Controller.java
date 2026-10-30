import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.oi.FileNotFoundException;

public class Controller {
    MovieCollection movieCollection = new MovieCollection();
    private FileHandler fileHandler = new FileHandler("movies.csv");
    private boolean changed;

    public void addMovie(String title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre) {
        movieCollection.addMovie(title, director, yearCreated, inColor, lengthInMinutes, genre);
        changed = true;
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
        boolean success = movieCollection.editMovie(movie, title, director, yearCreated, inColor, lengthInMinutes, genre );
        if(success){
            changed = true;
        }
        return success;

    }

    public boolean deleteMovie(Movie movie) {
        boolean success = movieCollection.deleteMovie(movie);
        if(success){
            changed = true;
        }
        return success;
    }

    public void markAsWatched(Movie movie, LocalDate date) {
        movie.markAsWatched(date);
        changed = true;
    }

    public ArrayList<Movie> getMoviesNotWatchedForDays(int days) {
        LocalDate limit = LocalDate.now().minusDays(days);
        return movieCollection.getMoviesNotWatchedSince(limit);
    }
    public int loadMovies() throws FileNotFoundException{
        ArrayList<Movie> movies = fileHandler.loadMovies();
        for(Movie movie: movies){
            movieCollection.addMovie(movie);
        }
        return movies.size();
    }
}
