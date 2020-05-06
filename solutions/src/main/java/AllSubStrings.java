import java.util.ArrayList;
import java.util.List;

/**
 * Given a String input and a String substring, return the amount of sub-strings that can be formed in input using substring.
 * You can only go from left to right, without mixing up the order of the input or substring.
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

        if (input.isEmpty() || substring.isEmpty() || substring.length() > input.length()) {
            return 0;
        } else {

            char [] all = input.toCharArray();
            char [] sub = substring.toCharArray();

            List<Character> list1 = new ArrayList<>();

            for(int i = 0; i < input.length(); i++) {
                //so if the char in the input is part of substring
                //then it goes into this new array
                if(substring.indexOf(all[i]) >= 0) {
                    list1.add(all[i]);
                }
            }
            char [] smaller = new char[list1.size()];
            //now put it into a smaller char array
            for (int i = 0; i < list1.size(); i++) {
                smaller[i] = list1.get(i);
            }


            System.out.println("input is " + input);
            System.out.println("smaller is " + list1.toString() + "\n");
            return rec(smaller, sub, 0, 0);
        }
    }

    public int rec(char [] all, char [] sub, int indexAll, int indexSub) {

        if(indexAll > all.length-1 || indexSub > sub.length-1) {
            return 0;
        }

        if(indexAll == all.length-1) {
            if (all[indexAll] == sub[indexSub]) {
                return 1;
            }
        }

        if(all[indexAll] != sub[indexSub]) {
            while (indexAll < all.length-1) {
                if(all[indexAll] == sub[indexSub]) {
                    break;
                } else {
                    indexAll++;
                }
            }
        }

        //the amount to return
        int amount = 0;
        //if last char of substring and it's in 'all', return 1
        if(indexSub == sub.length-1 && all[indexAll] == sub[indexSub]) {
            amount++;
        }

        //now after finding the (first) part of the substring you were looking for
        //bijv "A"
        //do the recursion (to find "B")
        amount+=rec(all, sub, indexAll+1, indexSub+1);
        //then continue to see if u can find the same part of substring further ahead in the input
        //so look for "A" further down the substring
        indexAll++;

        amount+= rec(all, sub, indexAll, indexSub);

        return amount;
    }
}
