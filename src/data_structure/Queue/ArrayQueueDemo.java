package data_structure.Queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args){
        //test the ArrayQueue
        //initialize
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; //get user input;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show): to show the queue");
            System.out.println("e(exit): to exit the little program");
            System.out.println("a(add): to add data to the queue");
            System.out.println("g(get): to get data out of the queue");
            System.out.println("h(head): to peek the very first data of the queue");
            key = scanner.next().charAt(0);
            switch(key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("Please enter a number");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = arrayQueue.getQueue();
                        System.out.printf("The number been taking out is %d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = arrayQueue.headQueue();
                        System.out.printf("The head data is %d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("Program exited. ");
    }

}

//Using array to simulate Queue - create a ArrayQueue class
class ArrayQueue {
    private int maxSize;//representing the maximum volume of the array
    private int front; //pointer pointing to the head;
    private int rear; //pointer pointing to the rear;
    private int[] arr; //storing the actual data;

    //constructor
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int [arrMaxSize];
        front = -1;
        rear = -1;
    }

    //check if the queue is full
    public boolean isFull(){
        return rear == maxSize -1;
    }

    //check if the queue is empty
    public boolean isEmpty(){
        return front == rear;
    }

    //add queue
    public void addQueue(int n){
        if(isFull()){
            System.out.println("queue is full");
            return;
        }
        rear ++;
        arr[rear] = n;
    }

    //get the data from the queue
    public int getQueue(){
        //check if the queue is empty;
        if(isEmpty()){
            throw new RuntimeException("the queue is empty. Cannot get the data.");
        }

        front ++;
        return arr[front];
    }

    //show all the elments
    public void showQueue(){
        if(isEmpty()) {
            System.out.println("No data. The queue is empty");
            return;
        }
        for(int i =0; i < arr.length; i++){
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    //show the head of the data, not to take out
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("it is empty");
        }
        return arr[front + 1];
    }
}