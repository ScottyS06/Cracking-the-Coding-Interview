package Arrays_and_Strings;

public class OneAway {
    public static void main(String[] args) {

    }

    public static boolean oneAway(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return oneAway(s2, s1);
        }

        int edits = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c1) {
                edits++;
            }

        }
        return edits <= 1;
    }
}
