import java.util.Scanner;

public class StrongPassword {

    public static class Solution {

        static int minimumNumber(int n, String password) {
            int res = 0;
            if (!password.matches(".*[0-9]+.*")){
                res ++;
            }
            if (!password.matches(".*[A-Z]+.*")){
                res ++;
            }
            if (!password.matches(".*[a-z]+.*")){
                res ++;
            }
            if (!password.matches(".*[!@#$%^&*()\\-+]+.*")){
                res ++;
            }
            if (n+res < 6) return 6 - n;
            return res;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            String password = in.next();
            int answer = minimumNumber(n, password);
            System.out.println(answer);
            in.close();
        }
    }

}