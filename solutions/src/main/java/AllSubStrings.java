import java.util.LinkedList;

/**
 * Given a String input and a String substring, return the amount of sub-strings that can be formed in input using substring.
 * You can only go from left to right
 * For example: input "ALJBCADBHYKQNZBC" with substring "ABC" has 3 sub-strings that can be formed.
 */
public class AllSubStrings {

    String input;
    String substring;

    public AllSubStrings(String input, String substring) {
        this.input = input;
        this.substring = substring;
    }

    public int solve() {
        return solve(this.input, this.substring);
    }

    public int solve(String input, String substring) {

        if (input.isEmpty() || substring.isEmpty()) {
            return 0;
        } else {
//            input = input.toUpperCase();
//            substring = substring.toUpperCase();
            char [] all = input.toCharArray();
            char [] sub = substring.toCharArray();
            LinkedList<Character> linkedList = new LinkedList<>();

            for(int i = 0; i < input.length(); i++) {
                //so if the char in the input is part of substring
                //then it goes into this new array
                if(substring.indexOf(input.charAt(i)) >= 0) {
                    linkedList.add(input.charAt(i));
                }
            }
            char [] smaller = new char[linkedList.size()];
            //now put it into a smaller char array
            for (int i = 0; i < linkedList.size(); i++) {
                smaller[i] = linkedList.get(i);
            }

            return rec(all, sub, 0, 0);
        }
    }

    public int rec(char [] all, char [] sub, int indexAll, int indexSub) {

        if(indexAll >= all.length-1) {
            return 0;
        }

        //if you've already found a substring, gotta start over!
        if(indexSub >= sub.length-1) {
            indexSub = 0;
        }

        if(all[indexAll] != sub[indexSub]) {
            while (indexAll <= all.length-1) {
                if(all[indexAll] == sub[indexSub]) {
                    break;
                } else {
                    indexAll++;
                }
            }
        }


        //now after finding the (first) part of the substring you were looking for
        //do the recursion
        return 0;
    }
}
