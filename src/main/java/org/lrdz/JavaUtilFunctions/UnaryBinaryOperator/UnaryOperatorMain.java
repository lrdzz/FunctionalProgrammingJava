package org.lrdz.JavaUtilFunctions.UnaryBinaryOperator;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorMain {
    //its similar to the operation function, but if the input object its the same of the return object, we use this interface.

    static UnaryOperator<String> concatInput = a -> "Concating the input: " + a;
    static UnaryOperator<String> toUpperCase = String::toUpperCase;


    public static void main(String[] args) {
        System.out.println(concatInput.apply("test"));
        System.out.println(toUpperCase.apply("helLo fRom java"));

        IntUnaryOperator predefinedIntegerUnary = n -> n*2;

        System.out.println(predefinedIntegerUnary.applyAsInt(6));
    }
}
