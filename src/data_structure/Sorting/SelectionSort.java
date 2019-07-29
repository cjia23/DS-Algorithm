package data_structure.Sorting;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectionSort {
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
        SelectSort(arr);
        //System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("time after bubble sorting is: " + date2Str);
    }

    public static void SelectSort(int[] arr) {
        for (int j = 0; j < arr.length;j++){
            int min = arr[j];
            int minIndex = j;
            for (int i = j; i < arr.length; i++) {
                if (min > arr[i]) {
                    //new minimum found
                    min = arr[i];
                    minIndex = i;
                }
            }
            //put min at arr[0] and
            if(minIndex != j) {
                arr[minIndex] = arr[j];
                arr[j] = min;
            }
            //System.out.printf("after %d round....", j+1);
            //System.out.println(Arrays.toString(arr));
        }
    }

}
