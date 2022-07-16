import java.util.Collection;
import java.util.HashMap;

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

        //String [] = new Array[AMS-LON, LON-PAR, etc etc]

        HashMap<String, String> fromTo = new HashMap<>();
        HashMap<String, String> toFrom = new HashMap<>();

        //make a parser thingy

        for (int i=0; i<=all.length-1; i++) {
            String[] fr = all[i].toUpperCase().replaceAll("\\s", "").split("-");
            System.out.println("i=" + i + "  " + fr[0] + "|" + fr[1]);
            if (fr.length == 2) {
                fromTo.put(fr[0], fr[1]);
                toFrom.put(fr[1], fr[0]);
            } else {
                return null; //throw new Exception("Amount of cities chained isn't 2");
            }
        }

        Collection<String> valuesFT = fromTo.values();
        Collection<String> valuesTF = toFrom.values();

        String startCity = "";
        String endCity = "";

        for (String k : fromTo.keySet()) { //for-loop -> T(n) = O(n)
            if (!toFrom.containsKey(k)) { //containsKey -> T(n) = O(1)
                startCity = k;
            }
        }

        for (String k2 : toFrom.keySet()) {
            if (!fromTo.containsKey(k2)) {
                endCity = k2;
            }
        }

        //now somehow chain from start city to end city

        String[] result = new String[all.length + 1];
        int index = 0;
        result[index++] = startCity;
        //do a for-loop of length all.length-1
        while (!startCity.equals(endCity)) {
            //enter the results in the result array so u can return
            String x = fromTo.get(startCity);
            result[index] = x;
            startCity = x;
            index++;

        }
        //fromTo.entrySet().stream().filter(e -> valuesTF.contains(e.getKey()));
        //https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html#values--
        //https://www.google.com/search?q=hashmap+in+java+time+complexity&rlz=1C1CHBF_enNL817NL817&sxsrf=ALeKk00wQ0woZS3by-7xXLkjDRYswvU1dQ:1594572049484&source=lnms&tbm=isch&sa=X&ved=2ahUKEwj2yM_kk8jqAhXPl-AKHVKkD0kQ_AUoAnoECA4QBA&biw=1745&bih=881#imgrc=MZ7bLMfjeBVURM
        //https://www.baeldung.com/java-stream-filter-lambda
        //https://dzone.com/articles/java-hashmap-search-and-sort

        return result;
    }
}
