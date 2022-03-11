package Arrays_and_Strings;

import java.util.*;

public class isPermutation {
    public static void main(String[] args) {
        String s1 = "aabb";
        String s2 = "bbac";

        System.out.println("Check permutation for " + s1 + " " + s2 + ": " + isPermutation(s1, s2));
    }

    public static boolean isPermutation(String s1, String s2) {
        // Approach
        //      - Store the chars and their counts of s1 into a HashMap
        //      - Loop through s2 and subtract from the counts in the HashMap
        //      - If the counts don't match up return false, if the hashmap is empty return true

        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!counts.containsKey(c)) {
                counts.put(c, 0);
            }
            counts.put(c, counts.get(c) + 1);
        }

        for (int i = 0 ; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (counts.containsKey(c)) {
               int count = counts.get(c);
               if (count - 1 == 0) {
                   counts.remove(c);
               } else {
                   counts.put(c, count - 1);
               }
            } else {
                return false;
            }
        }

        return counts.isEmpty();
    }


}
