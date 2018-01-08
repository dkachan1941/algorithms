import java.util.*;

public class SherlockAndTheValidString {

    static String isValid(String s){
        char[] chars = s.toCharArray();
        boolean reducedOnce = false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : chars) {
            Integer freq = map.get(ch);
            map.put(ch, freq == null ? 1 : freq + 1);
        }
        Integer previous = null;
        for (int value : map.values()) {
            if (previous == null ) {
                previous = value;
            } else {
                if (previous != value && value == 1) {
                    reducedOnce = true;
                    continue;
                }
                if (previous != value && Math.abs(previous - value) != 1) {
                    return "NO";
                } else if (previous != value && Math.abs(previous - value) == 1 && !reducedOnce) {
                    reducedOnce = true;
                    continue;
                }
                if (previous != value && Math.abs(previous - value) == 1 && reducedOnce ) return "NO";

                previous = value;
            }
        }
        return "YES";

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}