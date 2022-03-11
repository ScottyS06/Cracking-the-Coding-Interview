package Arrays_and_Strings;

import java.util.*;

public class PalindromePermutation {
    public static void main(String[] args) {
        String str = "abbcda";
        System.out.println("Check permutation \'" + str + "\':" + checkPalindromePermutation(str));
    }

    public static boolean checkPalindromePermutation(String str) {
        Map<Character, Integer> counts = new HashMap<>();

        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                if (!counts.containsKey(c)) {
                    counts.put(c, 0);
                }
                counts.put(c, counts.get(c) + 1);
            }
        }

        int oddCount = 0;
        for (char c: counts.keySet()) {
            int count = counts.get(c);
            if (count % 2 == 1) {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }
}
