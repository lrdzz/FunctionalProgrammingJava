package org.lrdz.Streams;

import org.lrdz.UtilPojos.Database;
import org.lrdz.UtilPojos.Videogame;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFinalOperatorMain {
    public static void main(String[] args) {
        Stream<Videogame> streamVideogames = Database.videogames.stream();
        //countOperator(streamVideogames);
        //forEachOperator(streamVideogames);
        reduceOperator(streamVideogames);
    }

    static void countOperator(Stream<Videogame> stream){
        System.out.println(stream.count()); //count quantity of elements
    }

    static void forEachOperator(Stream<Videogame> stream){
        stream.forEach(System.out::println); // iterate  every item
    }

    static void anyMatchOperator(Stream<Videogame> stream){
        boolean response = stream.anyMatch(v -> v.getTotalSold() > 1); //if any item match then return true
        System.out.println(response);
    }

    static void allMatchOperator(Stream<Videogame> stream){
        boolean response = stream.allMatch(v -> v.getTotalSold() > 1); //if all items match then return true
        System.out.println(response);
    }

    static void noneMatchOperator(Stream<Videogame> stream){
        boolean response = stream.noneMatch(v -> v.getTotalSold() > 11); //if 1 items apply the predicate then false.
        System.out.println(response);
    }


    static void findFirstOperator(Stream<Videogame> stream){
        Optional<Videogame> optionalFindFirst= stream.findFirst(); //return an optional of first item
        System.out.println(optionalFindFirst.get());
    }

    static void findAnyOperator(Stream<Videogame> stream){
        Optional<Videogame> optionalFindAny= stream.findAny(); //return an optional of any item
        System.out.println(optionalFindAny.get());
    }

    static void reduceOperator(Stream<Videogame> stream){
        //to apply a operation to a set of items.,
        Optional<Integer> resSum= stream
                .filter(Videogame::getIsDiscount)
                .map(Videogame::getTotalSold)
                .reduce(Integer::sum);
        System.out.println(resSum);
    }

    static void maxOperator(Stream<Videogame> stream){
        //return the max name in the list. zorro.
        Optional<Videogame> optionalVideogame= stream.max((a,b) -> a.getName().compareTo(b.getName()));
        System.out.println(optionalVideogame.get());
    }

    static void minOperator(Stream<Videogame> stream){
        //return the max name in the list. avengers.
        Optional<Videogame> optionalVideogame= stream.min((a,b) -> a.getName().compareTo(b.getName()));
        System.out.println(optionalVideogame.get());
    }
}
