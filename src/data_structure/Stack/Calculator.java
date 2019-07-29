package data_structure.Stack;

public class Calculator {
    public static void main(String [] args){
        //based on the previous thoughts, complete the calculator
        String expression = "30+2*7-20";
        //create two stacks
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        int index = 0; // used to scan
        int num1 = 0;
        int num2 = 0;
        char oper = 0;
        int res = 0;
        char ch = ' '; //every time the char will be stored here
        String keepNum = "";
        while(true){
            //get the every character of the expression
            ch = expression.substring(index, index+1).charAt(0);
            if(operStack.isOper(ch)){
                //if it is a operator, further check if the stack is empty or not
                if(!operStack.isEmpty()){
                    //depending on the priority of the operator
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        //take out two numbers
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = (char) operStack.pop();
                        res = numStack.cal(num1,num2,(char) oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    //if it is empty, then add
                    operStack.push(ch);
                }
            } else {
                //if it is number, add to the numStack
                //cannot add to stack directly, if it is a multi-digit number
                //need to check index+1, if it is a number then continue to check.
                //need to define a variable used to add up
                //numStack.push(ch-48);
                keepNum += ch;
                //if ch is the last digit of the expression, just add to numStack
                if(index == expression.length() -1){
                    numStack.push(Integer.parseInt(keepNum));
                }
                else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //if the next is a operator, then apush
                        numStack.push(Integer.parseInt(keepNum));
                        //clear the keepNum
                        keepNum = "";
                    }
                }
            }

            //let index+1 and check if it is the end of the expression
            index++;
            if(index >= expression.length()){
                break;
            }
        }

        //
        while(true){
            //if operStack if empty, numStack should only have one final number which is the result
            if(operStack.isEmpty()){
                break;
            } else{
                //take out two numbers
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = (char) operStack.pop();
                res = numStack.cal(num1,num2,oper);
                numStack.push(res);
                //operStack.push(ch);
            }
        }
        System.out.printf("The expression %s = %d", expression, numStack.pop());
    }

}

//create a stack, use the previous created stack but need to expand the functions
//
class ArrayStack2 {
    private int maxSize; //size of the stack
    private int [] stack; // using array to simulate Stack
    private int top = -1; //initialize to -1

    //constructor
    public ArrayStack2(int maxSize){
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

    //just look at the value without actually popping it
    public int peek(){
        return stack[top];
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

    //return the priority of the operators, pre-defined by chunyang
    //priority is represented by numbers
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-'){
            return 0;
        } else {
            return -1; //assume the calculator can only accepts +,-,*,/
        }
    }

    //check if it is a operator
    public boolean isOper(char val){
        return val == '+' || val == '-' || val =='*'|| val =='/';
    }

    //calculator function
    public int cal(int num1, int num2, char oper){
        int res = 0; //res is used to store the result
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num2/num1;
                break;
        }
        return res;
    }



}


