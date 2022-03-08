import java.util.*;

public class IsUnique {
    public static void main(String[] args) {
        String s = "a";
        System.out.println("String \'" + s + "\' is Unique: " + isUnique(s));
    }

    public static boolean isUnique(String str) {
        // Approach:
        //      - Add all characters and their counts to a HashMap
        //      - Then traverse the HashMap and ensure that no chars
        //      - have count > 1

        // Time Complexity: O(n)
        //      - traverse the string linearly twice
        // Space Complexity: O(n)
        //      - store chars in a hashmap

        Map<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!counts.containsKey(c)) {
                counts.put(c, 0);
            }
            counts.put(c, counts.get(c) + 1);
        }

        for (char c : counts.keySet()) {
            if (counts.get(c) > 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean isUnique2(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        // Time Complexity: O(nlogn + n)
        //      - traverse the string linearly twice
        // Space Complexity: O(n)
        //      - store chars in a hashmap

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                return false;
            }
        }
        return true;
    }


}
