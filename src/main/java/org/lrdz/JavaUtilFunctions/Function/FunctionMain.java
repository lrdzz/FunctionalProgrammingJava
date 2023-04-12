package org.lrdz.JavaUtilFunctions.Function;

import java.util.function.Function;

public class FunctionMain {

    static Function<Integer,Integer> multiply = n-> n*10;
    static Function<Integer,Integer> add = n-> n+10;
    static Function<Integer,Integer> addThenMultiply = add.andThen(multiply);
    static Function<Integer,Integer> addComposeMultiply = multiply.compose(add);

    public static void main(String[] args) {
        System.out.println(add.apply(5));
        System.out.println(multiply.apply(5));
        System.out.println(addThenMultiply.apply(5));
        System.out.println(addComposeMultiply.apply(5));
    }

}
