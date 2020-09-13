import org.junit.Test;

public class BoardingPassesTest {

    @Test
    public void test1() {
        String[] d = new String[4];
        d[0] = "  AMS  - LON";
        d[1] = " LON - PAR";
        d[2] = "PAR- WIL";
        d[3] = "WIL - uta";

        BoardingPasses bp = new BoardingPasses(d);
        bp.solve(d);
    }
}
