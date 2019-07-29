package data_structure.Stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String [] args){
        //test the arraystack
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; //control if exit the menu
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("show: to show the stack");
            System.out.println("exit: to exit the program");
            System.out.println("push: add data to stack");
            System.out.println("pop: take data out of the stack");
            System.out.println("Please enter: ");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("Please enter a number: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try{
                        int res = stack.pop();
                        System.out.printf("the data popped out is: %d", res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("Program has stooped");
    }

}

class ArrayStack {
    private int maxSize; //size of the stack
    private int [] stack; // using array to simulate Stack
    private int top = -1; //initialize to -1

    //constructor
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top ==maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        //check if it is full
        if(isFull()){
            System.out.println("the stack is full");
            return;
        }

        top++;
        stack[top] = value;
    }

    public int pop(){
        //check if it is empty
        if(isEmpty()){
            throw new RuntimeException("The stack is empty");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //loop and
    public void list(){
        if(isEmpty()){
            System.out.println("Stack is empty, no data.");
            return;
        }

        for(int i = top; i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

}
