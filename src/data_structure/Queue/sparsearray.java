package data_structure.Queue;

public class sparsearray {

    public static void main(String [] args){
        //create a 2D array 11X11
        //0: for no starting value; 1: for black; 2: for blue
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 6;

        System.out.println("Original 2D array: ");
        for(int[] row: chessArr1){
            for(int data: row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //1: to loop over the 2D array
        //get all the number of non-zero elements
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i ++){
            for (int j =0; j < chessArr1.length; j++){
                if(chessArr1[i][j] != 0 ){
                    sum++;
                }
            }
        }
        System.out.println("sum = " + sum);

        //2. create the sparse array
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1.length;
        sparseArr[0][2] = sum;

        //loop over the 2D array, store all non-zero value to sparse array
        int count = 0; //used to count the column where the non-zero value will be stored
        for (int i = 0; i < chessArr1.length; i ++){
            for (int j =0; j < chessArr1.length; j++){
                if(chessArr1[i][j] != 0 ){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //print out the sparse array
        System.out.println();
        System.out.println("The sparse array looks like this: ");
        for (int i = 0; i < sparseArr.length; i++){
            for (int j = 0; j < 3; j++){
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }

        //3.recover the sparse array back to 2D array
        //3.1 construct the array
        int chessArr2 [][] = new int [sparseArr[0][0]][sparseArr[0][1]];

        for(int i = 1; i < sparseArr.length; i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];

        }

        //3.2 print out the recovered 2D array
        System.out.println("Recovered 2D array: ");
        for(int[] row: chessArr2){
            for(int data: row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }



    }

}
