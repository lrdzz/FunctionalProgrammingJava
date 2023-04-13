package org.lrdz.Streams;

import org.lrdz.UtilPojos.Database;
import org.lrdz.UtilPojos.Videogame;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class ConstructorStreamsMain {
    public static void main(String[] args) {
        //create streams, method 1 (most common)
        Stream<Videogame> myStream = Database.videogames.stream();
        myStream.forEach(System.out::println);
        //method 2
        System.out.println("-----------");
        Integer[] myArrayInt = {12,3,1,3,1,44,4};
        Stream<Integer> myStreamInt = Arrays.stream(myArrayInt);
        myStreamInt.forEach(System.out::println);
        //method 3
        System.out.println("-----------");
        Stream.of("hola","lol").forEach(System.out::println);
        //method 4
        System.out.println("-----------");
        DoubleStream myDoubleStream = DoubleStream.of(1.3,2.3,21.2);
        myDoubleStream.forEach(System.out::println);

    }
}
