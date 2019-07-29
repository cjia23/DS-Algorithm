package data_structure.Sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//an improvement based on insertion sort
//greatly reduce the number of times, number value moves
public class ShellSort {

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
        shellSort2(arr);
        //System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("time after bubble sorting is: " + date2Str);
    }

    //used sequential to write out shell sorting
    public static void shellSort(int [] arr) {
        int temp = 0;
        //int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //shell sorting first round
            //thoughts: split the 10 data into 5 groups
            for (int i = gap; i < arr.length; i++) {
                //loop over every element inside the group
                for (int j = i - gap; j >= 0; j -= gap) {
                    //if the current element is greater than the boot element, then need to reverse
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //count++;
            //System.out.printf("After the %d round of sorting: ",count);
            //System.out.println(Arrays.toString(arr));

        }
    }

    public static void shellSort2(int [] arr){


        //int count = 0;
        //used gap and gradually reduce it
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //shell sorting first round
            //thoughts: split the 10 data into 5 groups
            for (int i = gap; i < arr.length; i++) {
                //loop over every element inside the group
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j-gap]){
                    while(j - gap>=0 && temp < arr[j-gap]){
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //when exiting the while loop, we found the position
                    arr[j] = temp;
                }
            }
            //count++;
            //System.out.printf("After the %d round of sorting: ",count);
            //System.out.println(Arrays.toString(arr));
        }
    }
}
