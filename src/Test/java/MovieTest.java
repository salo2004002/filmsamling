import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MovieTest {
    @Test
    void constructorSetsAllAttributes(){

       Movie movie = new Movie("Godzilla", "Ishirō Honda", 1954, false, 96, "Sci-fi");
       assertEquals("Godzilla",movie.getTitle());
       assertEquals("Ishirō Honda", movie.getDirector());
       assertEquals(1954, movie.getYearCreated());
       assertFalse(movie.isInColor());
       assertEquals(96, movie.getLengthInMinutes());
       assertEquals("Sci-fi", movie.getGenre());
    }


}