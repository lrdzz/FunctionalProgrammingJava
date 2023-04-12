package org.lrdz.ObjectMethodReference;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ObjectReference {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        //its for generate a for using stream and lambda.
        IntStream repeat = IntStream.range(1,11);
        //repeat.forEach(i -> list.add(i));
        repeat.forEach(list::add);
        System.out.println(list); // print the list of 1 to 10.
    }
}
