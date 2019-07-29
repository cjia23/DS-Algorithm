package data_structure.recursion;

public class RecursionTest {
    public static void main(String [] args){
        //learn about how recursion works
        test(4);

        //test factorial
        int res = factorial(5);
        System.out.println("res =" + res);
    }

    //print problem
    public static void test(int n){
        if(n>2){
            test(n-1);
        } else{
            System.out.println("n="+n);
        }
        //System.out.println("n="+n);
    }

    //factorial
    public static int factorial(int n){
        if(n == 1){
            return 1;
        } else {
            return factorial(n-1)*n;
        }
    }

}