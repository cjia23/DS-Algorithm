package data_structure.linkedlist;

import java.util.Stack;
//to show basic usage of Stack
public class TestStack {
    public static void main(String [] args){
        Stack<String> stack = new Stack();
        //get in
        stack.add("jacky");
        stack.add("tom");
        stack.add("smith");

        //take out
        //first in, last out.
        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}
