package org.lrdz.JavaUtilFunctions.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateMain {

    static Predicate<Integer> isGreaterThan5 = n -> n>5;

    static Predicate<Integer> isLessThan300 = n -> n<300;

    static Predicate<Integer> isGreaterThan5AndLessThan300 = isGreaterThan5.or(isLessThan300); // or , and
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,66,100,200,300,2220));
        ///////////method that receive a predicate.
        numbers.removeIf(isGreaterThan5);
        //numbers.removeIf(isGreaterThan5.negate()); // to negate the answer
        System.out.println(numbers);
    }
}
