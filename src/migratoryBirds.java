import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class migratoryBirds {

    static int migratoryBirds(int n, int[] ar) {
        // Complete this function
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i < ar.length; i++){
            if (hm.containsKey(ar[i])){
                hm.put(ar[i], hm.get(ar[i]) + 1);
            } else {
                hm.put(ar[i], 1);
            }
        }

        Map.Entry<Integer, Integer> res = null;
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            if (res == null || entry.getValue().compareTo(res.getValue()) > 0){
                res = entry;
            }
        }

        return res != null ? res.getKey() : 0;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }

}