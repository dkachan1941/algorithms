import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class SherlockAndTheValidStringWoHashmap {

    static String isValid(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        ArrayList<Integer> count = new ArrayList<>();
        int freq = 1;
        boolean reducedOnce = false;

        for (int i = 0; i < chars.length-2; i++){
            if(chars[i] == chars[i+1]) {
                freq++;
                if (i == chars.length - 3 && chars[chars.length-2] == chars[chars.length-1]){
                    freq++;
                    count.add(freq);
                }
            } else if (chars[i+1] == chars[i+2] && chars[i] != chars[i+1]){
                count.add(freq);
                freq = 1;
            } else {
                freq = 1;
                count.add(freq);
                if (i == chars.length - 3 && chars[chars.length-2] != chars[chars.length-1]){
                    count.add(freq);
                }

            }
        }

        for (int l = 0; l < count.size()-1; l++) {
            if (!Objects.equals(count.get(l), count.get(l + 1))) {
                if (count.get(l) != count.get(l + 1)-1) {
                    return "NO";
                } else if (count.get(l) == count.get(l + 1)-1 && reducedOnce) {
                    return "NO";
                }
                if (count.get(l) == count.get(l + 1)-1 && !reducedOnce) {
                    reducedOnce = true;
                }
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
