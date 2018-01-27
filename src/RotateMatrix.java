
public class RotateMatrix {

    public static void main(String[] args) {

        int matrix[][] = {
                {1,2,3},
                {4,5,6},
                {33,55,66},
                {9,8,7}
        };

        int mLen = matrix.length;
        int mWidth = matrix[0].length;


        // rotate by 90 degrees clockwise
//        int rotatedMatrix[][] = new int[mWidth][mLen];
//        for (int i=0; i<matrix.length; i++){
//            for (int j=0; j<matrix[i].length; j++){
//                rotatedMatrix[j][mLen-i-1] = matrix[i][j];
//            }
//        }

//         rotate by 90 degrees contraclockwise
        int rotatedMatrix[][] = new int[mWidth][mLen];
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                rotatedMatrix[j][mLen-i-1] = matrix[mLen-i-1][mWidth-j-1];
            }
        }

        // print matrix
        for (int i=0; i<rotatedMatrix.length; i++){
            for (int j=0; j<rotatedMatrix[i].length; j++){
                System.out.print(rotatedMatrix[i][j] + " ");
            }
            System.out.println("");
        }

    }

}