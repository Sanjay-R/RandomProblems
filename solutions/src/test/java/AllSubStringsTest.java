import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllSubStringsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testSolveDefault() {
        String input = "ALJBCADBHYKQNZBC";
        String substring = "ABC";
        AllSubStrings allSubStrings = new AllSubStrings(input, substring);
        assertEquals(allSubStrings.solve(input, substring), 6);
    }

    @Test
    void testSameExactInputAsSubstring() {
        String input = "ABC";
        String substring = "ABC";
        AllSubStrings allSubStrings = new AllSubStrings(input, substring);
        assertEquals(allSubStrings.solve(input, substring), 1);
    }
}