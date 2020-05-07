import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AllSubStringsTest {

    @Test
    public void testSolveDefault() {
        String input = "ALJBCADBHYKQNZBCA";
        String substring = "ABC";
        AllSubStrings allSubStrings = new AllSubStrings(input, substring);
        assertEquals(6, allSubStrings.solve(input, substring));
    }

    @Test
    public void testSameExactInputAsSubstring() {
        String input = "ABC";
        String substring = "ABC";
        AllSubStrings allSubStrings = new AllSubStrings(input, substring);
        assertEquals(1, allSubStrings.solve(input, substring));
    }

}