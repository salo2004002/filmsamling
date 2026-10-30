import java.time.LocalDate;
import java.util.ArrayList;

public class MovieCollection {

    private ArrayList<Movie> movies;

    public MovieCollection() {
        this.movies = new ArrayList<>();
    }


    public void addMovie(String title, String director, int yearCreated, boolean inColor, int lengthInMinutes, String genre) {
        Movie movie = new Movie(title, director, yearCreated, inColor, lengthInMinutes, genre);
        movies.add(movie);
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public int getNumberOfMovies() {
        return movies.size();
    }

    public ArrayList<Movie> searchMovies(String searchText) {
            ArrayList<Movie> matches = new ArrayList<>();
            String text = searchText.toLowerCase();
            for (Movie movie : movies) {
                if (movie.getTitle().toLowerCase().contains(text)) {
                    matches.add(movie);
                }
            }
            return matches;
    }

    public boolean editMovie(Movie movie, String title, String director, int yearCreated,
                             boolean inColor, int lengthInMinutes, String genre) {
        if (!movies.contains(movie)) {
            return false;
        }
        new Movie (title, director, yearCreated, inColor, lengthInMinutes, genre);
        movie.setTitle(title);
        movie.setDirector(director);
        movie.setYearCreated(yearCreated);
        movie.setInColor(inColor);
        movie.setLengthInMinutes(lengthInMinutes);
        movie.setGenre(genre);
        return true;
    }

    public boolean deleteMovie(Movie movie) {
        return movies.remove(movie);
    }

    public ArrayList<Movie> getMoviesNotWatchedSince(LocalDate limit) {
        ArrayList<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (!movie.hasBeenWatched() || movie.getLastWatched().isBefore(limit)) {
                result.add(movie);
            }
        }
        return result;
    }
    public void addMovie(Movie movie){
        movies.add(movie);
    }
}

