import org.junit.jupiter.api.Test;


import java.time.LocalDate;

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
    @Test
    void emptyTitelThrows(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Movie("", "Steven", 2000,true, 120, "Action");
        });
    }
    @Test
    void emptyDirectorThrows(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Movie("abc", "", 2000,true, 120, "Action");
        });

    }
    @Test
    void yearAcceptedAtBoundary(){
       Movie movie = assertDoesNotThrow(() -> new Movie("abc", "abc", 1888, true, 148, "dd"));

        assertEquals(1888, movie.getYearCreated());
    }
    @Test
    void yearRejectedWhenTooOld() {
        assertThrows(IllegalArgumentException.class, () ->{ new Movie("abc", "abc", 1887, true, 148, "dd");
        });

    }
    @Test
    void yearRejectedWhenTooFarInFuture(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Movie("abc", "abc", LocalDate.now().getYear() +2, true, 90, "dd");
        });
    }

    @Test
    void lengthRejectedWhenZero(){
        assertThrows(IllegalArgumentException.class, () ->{
            new Movie("abd", "adc", 2024, true, 0, "dd");
        });

    }
    @Test
    void emptyGenreThrows() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Movie("abc", "abc", 2023, true, 234, "");
        });
    }
}