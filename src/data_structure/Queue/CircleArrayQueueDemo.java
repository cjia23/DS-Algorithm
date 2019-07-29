package data_structure.Queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String [] args){
        System.out.println("test the array");
        //test the ArrayQueue
        //initialize
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);// set as 4, but actual maxsize is 3
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
                    System.out.println("front is " + arrayQueue.getFront());
                    System.out.println("rear is " + arrayQueue.getRear());
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
class CircleArrayQueue {
    private int maxSize;//representing the maximum volume of the array
    //pointer pointing to the first element of the array, which is arr[front];
    // front = 0 for start
    private int front;
    //rear pointing to the position plus extra one of the very last element;
    //rear = 0
    private int rear;
    private int[] arr; //storing the actual data;

    //constructor
    public CircleArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int [maxSize];
        front = 0;
        rear = 0;
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    //check if the queue is full
    public boolean isFull(){
        return (rear + 1)%maxSize == front;
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
        //add the data directly
        arr[rear] = n;
        //move the rear pointer backward, consider the mold
        rear = (rear +1)%maxSize;
    }

    //get the data from the queue
    public int getQueue(){
        //check if the queue is empty;
        if(isEmpty()){
            throw new RuntimeException("the queue is empty. Cannot get the data.");
        }

        //here need to analyze front is the pointing the very first element
        //1. firstly store the front val to a temp variable
        //2. make front pointer move backward
        //3. return the temp variable
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    //show all the elements
    public void showQueue(){
        if(isEmpty()) {
            System.out.println("No data. The queue is empty");
            return;
        }

        //thoughts: from front to loop, loop how many elements
        //
        for(int i = front; i < front + size(); i++){
            System.out.printf("arr[%d] = %d\n", i%maxSize, arr[i%maxSize]);
        }
    }

    //function to find out how many elements in the circle
    public int size(){
        return (rear + maxSize -front)%maxSize;
    }

    //show the head of the data, not to take out
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("it is empty");
        }
        return arr[front + 1];
    }
}