
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {
    private static final String TEST_FILE = "test-movies.csv";
    private FileHandler fileHandler;

    @BeforeEach
    void setUp(){
        fileHandler = new FileHandler(TEST_FILE);
    }
    @AfterEach
    void tearDown(){
        File file = new File(TEST_FILE);
        file.delete();
    }

    @Test
    void saveAndLoadRoundTrip() throws FileNotFoundException {
        ArrayList<Movie> movies = new ArrayList<>();
        Movie m1 = new Movie("Håkan Æøå", "Director One", 2000, true, 100, "Drama");
        m1.markAsWatched(LocalDate.of(2024, 1, 1));
        Movie m2 = new Movie("Movie Two", "Director Two", 1999, false, 90, "Comedy");
        movies.add(m1);
        movies.add(m2);

        fileHandler.saveMovies(movies);
        ArrayList<Movie> loaded = fileHandler.loadMovies();

        assertEquals(2, loaded.size());
        assertEquals("Håkan Æøå", loaded.get(0).getTitle());
        assertEquals(LocalDate.of(2024, 1, 1), loaded.get(0).getLastWatched());
        assertFalse(loaded.get(1).hasBeenWatched());
    }

    @Test
    void saveEmptyListThenLoadGivesEmptyList() throws FileNotFoundException {
        fileHandler.saveMovies(new ArrayList<>());
        ArrayList<Movie> loaded = fileHandler.loadMovies();
        assertTrue(loaded.isEmpty());
    }

    @Test
    void loadMissingFileThrows() {
        FileHandler missing = new FileHandler("does-not-exist.csv");
        assertThrows(FileNotFoundException.class, missing::loadMovies);
    }

    @Test
    void brokenLinesAreSkippedAndCounted() throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(TEST_FILE));
        output.println("title;director;yearCreated;inColor;lengthInMinutes;genre;lastWatched");
        output.println("Good Movie;Director;2000;true;100;Drama;");
        output.println("Too;Few;Fields");
        output.println("Bad Year;Director;notANumber;true;100;Drama;");
        output.close();

        ArrayList<Movie> loaded = fileHandler.loadMovies();

        assertEquals(1, loaded.size());
        assertEquals(2, fileHandler.getSkippedLineCount());
    }

}