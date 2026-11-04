package domainmodel;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TitleComparatorTest {
    private Movie casablanca;
    private Movie psycho;
    private Movie jaws;

    @BeforeEach
    void setUp(){
        casablanca = new Movie("Casablanca", "abc", 1942, false, 102, "abc");
        psycho = new Movie("Psycho", "abc", 1960, false, 109, "abc");
        jaws = new Movie("Jaws", "abc", 1988, true, 132, "abc");

    }
    @Test
    void titelComparatorIgornCase(){
        Movie jawsUpperCase = new Movie("JAWS", "abc", 1988, true, 132,"abc");
        TitleComparator comparator = new TitleComparator();
        assertEquals(0, comparator.compare(jaws, jawsUpperCase));
    }
    @Test
    void titelComparatorStort(){
        TitleComparator comparator = new TitleComparator();
        assertTrue(comparator.compare(casablanca, jaws) < 0);
        assertTrue(comparator.compare(psycho,jaws) > 0 );

    }



}