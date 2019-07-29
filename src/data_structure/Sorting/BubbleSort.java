package data_structure.Sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {

        //O(n^2)
        //int arr[] = {-1, 9, -2, 10, 3};
        //System.out.println(Arrays.toString(arr));

        //check the bubble sort speed O(n^2),giving 80,000 data and test
        //create 80000 random numbers
        int[] arr = new int[80000];
        for(int i =0; i < arr.length; i++){
            arr[i] = (int) (Math.random()* 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("time before bubble sorting is: " + date1Str);

        //System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        //System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("time after bubble sorting is: " + date2Str);
    }

    public static void bubbleSort(int [] arr){
        //in order to better understand. we will show the evolution process
        int temp = 0; //temporary variable
        boolean flag = false; //mark if any reversion has happened
        for (int i = 0; i < arr.length - 1;i++){

            for (int j = 0; j < arr.length - 1-i; j++) {
                //if the previous number is bigger than the latter, reverse
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            //System.out.printf("After the %d round of sorting",i+1);
            //System.out.println(Arrays.toString(arr));

            if(!flag){
                break;
            } else {
                flag = false;
                //reset flag to true to do the next check
            }
        }
    }

}
