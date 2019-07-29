package data_structure.Sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertionSort {
    public static void main(String [] args){
        int[] arr = new int[80000];
        for(int i =0; i < arr.length; i++){
            arr[i] = (int) (Math.random()* 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("time before bubble sorting is: " + date1Str);

        //System.out.println(Arrays.toString(arr));
        insertSort(arr);
        //System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("time after bubble sorting is: " + date2Str);
    }

    //Insertion Sort
    public static void insertSort(int[] arr){
        int insertVal = 0;
        int insertIndex = 0;

        for(int i = 1; i< arr.length; i++){
            insertVal = arr[i];
            insertIndex = i-1;
            while(insertIndex >=0 && insertVal < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            //to improve if we need to give the value
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            //System.out.printf("The %d round of sorting: ", i);
            //System.out.println(Arrays.toString(arr));
        }
    }

}
