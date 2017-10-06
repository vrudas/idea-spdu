package io.idea.spdu._5_refactoring;

public class _2_Extracting {

    public static void main(String[] args) {
//        EXTRACT AS CONSTANT
        System.out.println("Current Java version is " + 9);


//        EXTRACT AS VARIABLE
//        1
//        2


//        EXTRACT TO METHOD
//        System.out.println(x + y);

//        System.out.println(x + y);


//        EXTRACT TO METHOD PARAMETER
        System.out.println(sqr());
    }

    private static int sqr() {
        return 2 * 2;
    }
}
