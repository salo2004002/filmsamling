import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    private MovieCollection collection;

    @BeforeEach
    void setUp(){
        collection = new MovieCollection();
        collection.addMovie("The Godfather", "Francis Ford Coppola", 1972, true, 175, "Crime");
        collection.addMovie("Godzilla", "Ishirō Honda", 1954, false, 96, "Sci-fi");
        collection.addMovie("Casablanca", "Michael Curtiz", 1942, false, 102,"Drama");

    }
    @Test
    void collectionHas(){
        assertEquals(3, collection.getNumberOfMovies());
    }

    @Test
    void searchMovie(){
       ArrayList<Movie> result = collection.searchMovies("god");

        assertEquals(2, result.size());
    }

    @Test
    void searchMovieCaps(){
        ArrayList<Movie> result = collection.searchMovies("CASA");

        assertEquals(1,result.size() );


    }
    @Test
    void searchMovieNotFound(){
        ArrayList<Movie> result = collection.searchMovies("Titanic");

        assertEquals(0, result.size());
    }
    @Test
    void movieToDelite(){
        ArrayList<Movie> found = collection.searchMovies("Godfather");
        Movie movieToDelete = found.get(0);

        boolean wasDelited = collection.deleteMovie(movieToDelete);


        assertTrue(wasDelited);
        assertEquals(2, collection.getNumberOfMovies());
    }
    @Test
    void moiveToDeliteNotThere(){
        Movie movie = new Movie("Titanic", "James Cameron", 1997, true, 195, "Romance");

        boolean wasDelited = collection.deleteMovie(movie);

        assertFalse(wasDelited);
        assertEquals(3, collection.getNumberOfMovies());
    }
    @Test
    void editMovie(){
        ArrayList<Movie> found = collection.searchMovies("Casablanca");
        Movie movieToEdit = found.get(0);

       boolean wasEdited = collection.editMovie(movieToEdit, "The Casablanca", "SIv", 1994, false, 98, "Romantic");

       assertTrue(wasEdited);
       assertEquals("The Casablanca", movieToEdit.getTitle());
       assertEquals("SIv", movieToEdit.getDirector());
    }
    @Test
    void editMovieWhitInvalidValueCHangesNothin(){
        Movie movie = collection.searchMovies("Casablanc").get(0);
        String originalTitle = movie.getTitle();

        assertThrows(IllegalArgumentException.class, ()-> collection.editMovie(movie,"", "siv",1998,false,30,"romatic"));

        assertEquals(originalTitle,movie.getTitle());
    }



}