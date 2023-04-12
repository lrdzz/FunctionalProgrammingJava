package org.lrdz.ObjectMethodReference;

import java.util.function.BiPredicate;

public class ArbitraryMethodReference {
    public static void main(String[] args) {
        BiPredicate<String,String> equals = (s1,s2) -> s1.equals(s2);
        System.out.println(equals.test("a","b"));
        BiPredicate<String,String> equalsReference = String::equals;
        System.out.println(equalsReference.test("a","a"));


    }
}
