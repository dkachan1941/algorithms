public class StringRotation {

    public static void main(String[] args) {
        String input = "waterbottle";
        String rotated = "erbottlewat";

        for (int i = 0; i < input.length(); i++){
            StringBuilder sb = new StringBuilder();
            for (int j = i+1; j < input.length(); j++){
                sb.append(input.substring(j,j+1));
            }
            sb.append(input.substring(0,i+1));
            if (rotated.equals(sb.toString())){
                System.out.println(String.format("%s is a rotation of %s", rotated, input));
                return;
            }
        }
        System.out.println(String.format("%s is not a rotation of %s", rotated, input));
    }

}
