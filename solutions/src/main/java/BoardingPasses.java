/**
 * Imagine having a bunch of plane tickets for your upcoming connecting flights, all nicely set and ordered in your hands.
 * Suddenly some kid bumps into you at the airport and you drop all your tickets on the ground. GREAT!
 * Now you have to place them again in the correct order.
 * You decide to find the ticket for your current departure and that way have every ticket after that be a connecting flight, up until your last destination.
 *
 * <b>Re-order your tickets from starting city to end.</b>
 *
 * We'll assume a few things.
 * <ul>
 *     <li>There are no loops: so you will depart from one location and eventually arrive at another (no cities that are traveled twice).</li>
 *     <li>Cities will be passed as pairs of two (departure - arrival).</li>
 *     <li>Output the correct ordering of the cities from start to finish.</li>
 *     <li>You can choose how you want to output the result, as long as it's clear what the order of the cities are.</li>
 * </ul>
 */
public class BoardingPasses {

    String[] all; //form of FROM-TO

    public BoardingPasses(String[] all) {
        this.all = all;
    }

    /**
     * Given that you have a bunch of boarding passes but you drop them to the floor and their order gets messed up.
     * You depart off from one city, having layovers until eventually you reach your end city.
     * Re-order them (from starting city to end)!
     * There are no loops (no cities that are traveled twice).
     * @param all The input with the cities as an array of "departure - arrival" strings.
     * @return
     */
    public String[] solve(String[] all) {
        return null;
    }
}
