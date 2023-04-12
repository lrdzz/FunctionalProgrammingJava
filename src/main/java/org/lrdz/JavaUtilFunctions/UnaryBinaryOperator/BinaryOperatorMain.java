package org.lrdz.JavaUtilFunctions.UnaryBinaryOperator;

import java.util.function.BinaryOperator;

public class BinaryOperatorMain {
    //extend of biFunction (and simplified the generic Objects to only one.
    static BinaryOperator<String> normalizerFunc = (a,b) -> a.toUpperCase() + " " + b.toLowerCase();
    public static void main(String[] args) {
        System.out.println(normalizerFunc.apply("hello" , "WORLD"));
    }
}
