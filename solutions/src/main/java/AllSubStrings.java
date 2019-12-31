import java.util.LinkedList;

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

        if (input.isEmpty() || substring.isEmpty()) {
            return 0;
        } else {
//            input = input.toUpperCase();
//            substring = substring.toUpperCase();
            char [] all = input.toCharArray();
            char [] sub = substring.toCharArray();
            /*
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
             */

            System.out.println("input is " + input);
//            System.out.println("all is " + all[0] + all[1] + all[2]);
//            System.out.println("sub is " + sub[0] + sub[1] + sub[2]);
            System.out.println("");
            return rec(all, sub, 0, 0);
        }
    }

    public int rec(char [] all, char [] sub, int indexAll, int indexSub) {

        if(indexAll == all.length-1) {
            if(all[indexAll] == sub[indexSub]) {
                System.out.println("index " + indexAll + " has " + sub[indexSub] + " -> return 1 in start");
                return 1;
            }
        } else if(indexAll > all.length-1) {
            System.out.println("indexAll > all.length-1 -> return 0 in start");
            return 0;
        }

        //if you've already found a substring, gotta start over!
        /*
        if(indexSub >= sub.length-1) {
            indexSub = 0;
        }
         */

        if(all[indexAll] != sub[indexSub]) {
            while (indexAll <= all.length-1) {
                if(all[indexAll] == sub[indexSub]) {
                    break;
                } else {
                    indexAll++;
                }
            }
        }

        System.out.println(" index " + indexAll + " por " + sub[indexSub]);

        //the amount to return
        int amount = 0;
        //if last char of substring and last char in all, return 1
        if(indexSub == sub.length-1 && all[indexAll] == sub[indexSub]) {
            System.out.println("indexAll=" + indexAll + " for " + sub[indexSub] + "-> return 1");
            return 1;
        }

        //now after finding the (first) part of the substring you were looking for
        //bijv "A"
        //do the recursion (to find "B")
        amount+=rec(all, sub, indexAll+1, indexSub+1);
        //then continue to see if u can find the same part of substring further ahead in the input
        //so look for "A" further down the substring
        System.out.print("back at indexAll is " + indexAll + " for " + sub[indexSub]);

//        int next = indexAll+1;
//        while(next < all.length) {
//            amount+=rec(all, sub, next, indexSub+1);
//            next+=1;
//        }

        indexAll++;
        System.out.println(", send indexAll is " + indexAll);
        amount+= rec(all, sub, indexAll, indexSub);
        System.out.println("amount is " + amount + " for " + "indexAll=" + indexAll + "->" + sub[indexSub]);
        return amount;
    }
}
