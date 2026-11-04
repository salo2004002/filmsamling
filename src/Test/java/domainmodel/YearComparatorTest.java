package domainmodel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class YearComparatorTest {
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
    void yearComparatorSameYearGivesZero(){
        Movie movie4 = new Movie("abc", "abc", 1960, false, 100,"abc");
        YearComparator comparator = new YearComparator();
        assertEquals(0, comparator.compare(psycho, movie4));
    }

    @Test
    void yearComparatorStortOldesFirst(){
        YearComparator comparator = new YearComparator();
        assertTrue(comparator.compare(casablanca, psycho) < 0);
        assertTrue(comparator.compare(jaws, psycho) > 0 );
    }

}