package domainmodel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


class DirectorComparatorTest {
    private Movie casablanca;
    private Movie psycho;
    private Movie jaws;

    @BeforeEach
    void setUp(){
        casablanca = new Movie("Casablanca", "aaa", 1942, false, 102, "abc");
        psycho = new Movie("Psycho", "bbb", 1960, false, 109, "abc");
        jaws = new Movie("Jaws", "ddd", 1988, true, 132, "abc");

    }
    @Test
    void directorComparatorIgornCase(){
        Movie directorUpperCase = new Movie("jaws", "DDD", 1988, true, 132,"abc");
        DirectorComparator comparator = new DirectorComparator();
        assertEquals(0, comparator.compare(jaws, directorUpperCase));
    }
    @Test
    void directorComparatorStort(){
        DirectorComparator comparator = new DirectorComparator();
        assertTrue(comparator.compare(casablanca, jaws) < 0);
        assertTrue(comparator.compare(psycho,jaws) < 0 );

    }


}