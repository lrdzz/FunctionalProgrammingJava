package org.lrdz.JavaUtilFunctions.Consumer;

import java.util.Map;

public class BiConsumerMain {
    public static void main(String[] args) {
        Map<Boolean,String> map = Map.of(true,"something is true", false, "something is false");
        map.forEach((k,v) -> System.out.println("The key " + k + " means that: " + v));
    }
}
