package org.lrdz.JavaUtilFunctions.Consumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ConsumerMain {
    //receives something and return void.
    public static void main(String[] args) {
        Set<Integer> nums = Set.of(1,2,3,4,5);
        List<Integer> squares = new LinkedList<>();
        nums.forEach(n-> squares.add(n*n));
        System.out.println(squares);

    }
}
