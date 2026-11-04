package domainmodel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GenreComparatorTest {
    private Movie casablanca;
    private Movie psycho;
    private Movie jaws;

    @BeforeEach
    void setUp(){
        casablanca = new Movie("Casablanca", "abc", 1942, false, 102, "aaa");
        psycho = new Movie("Psycho", "abc", 1960, false, 109, "bbb");
        jaws = new Movie("Jaws", "abc", 1988, true, 132, "ddd");

    }
    @Test
    void genreComparatorIgornCase(){
        Movie genreUpperCase = new Movie("jaws", "abc", 1988, true, 132,"DDD");
        GenreComparator comparator = new GenreComparator();
        assertEquals(0, comparator.compare(jaws, genreUpperCase));
    }
    @Test
    void genreComparatorStort(){
        GenreComparator comparator = new GenreComparator();
        assertTrue(comparator.compare(casablanca, jaws) < 0);
        assertTrue(comparator.compare(psycho,jaws) < 0 );

    }

}