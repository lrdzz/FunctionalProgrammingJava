package org.lrdz.Streams;

import org.lrdz.UtilPojos.BasicVideogame;
import org.lrdz.UtilPojos.Database;
import org.lrdz.UtilPojos.Review;
import org.lrdz.UtilPojos.Videogame;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOperators {
    public static void main(String[] args) {
        Stream<Videogame> videogameStream = Database.videogames.stream();
        flatMapvsMap(videogameStream);
    }

    static void distinctOperator(Stream<Videogame> stream){
        System.out.println(stream.distinct().count()); //number of distinct elements
    }

    static void limitOperator(Stream<Videogame> stream){
        //return a list for example of the firsts 5 elements
        List<Videogame> r = stream.limit(5).collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    static void skipOperator(Stream<Videogame> stream){
        //return a list for example of the next items of the firsts 5 elements
        List<Videogame> r = stream.skip(5).collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    static void filterOperator(Stream<Videogame> stream){
        //filter the stream by conditions Predicate.
        List<Videogame> r = stream
                .filter(v ->  v.getPrice() > 5.0)
                .filter(v-> v.getOfficialWebsite().contains("forza"))
                .collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    static void mapOperator(Stream<Videogame> stream){
        //convert the stream to a type of list for example.
        List<BasicVideogame> basicVideogamesr = stream
                .map(v->{
                    return BasicVideogame.builder()
                            .name(v.getName())
                            .price(v.getPrice())
                            .console(v.getConsole())
                            .build();
                })
                .collect(Collectors.toList());
        basicVideogamesr.forEach(System.out::println);
    }

    static void flatMapOperator(Stream<Videogame> stream){
        //if every item of  the stream has a list,  then we can flat every list into one stream
        List<Review> listOfReviews = stream.flatMap(v -> v.getReviews().stream()).collect(Collectors.toList());
        listOfReviews.forEach(System.out::println);
    }

    static void flatMapvsMap(Stream<Videogame> stream){
        //we are gonna count the number of reviews of all database
        //using map we got a list of list, and we have to re iterate to count every list and final sum
        List<Integer> usingMap = stream.map(videogame -> videogame.getReviews().size()).collect(Collectors.toList());
        //using flatmap we got the number instantly, because all the items put their list into 1 stream, and we can count that final stream.
        Long usingFlatMap = stream.flatMap(v ->  v.getReviews().stream()).count();
        System.out.println(usingFlatMap);
    }

    static void peekOperator(Stream<Videogame> stream){
        //peek is the forEach but intermediate, return a stream.
        stream.peek(System.out::println);
    }

    static void sortOperator(Stream<Videogame> stream){
        //we can order the items comparing those that have less reviews to more reviews.
        List<Videogame> listSorted = stream
                .sorted(Comparator.comparingInt(v-> v.getReviews().size()))
                .collect(Collectors.toList());
    }


    static void takeWhileOperator(Stream<Videogame> stream){
        //take all  items before encounters the condition, we first order our items alphabetical a - z
        List<Videogame> r = stream
                .sorted(Comparator.comparing(Videogame::getName))
                .takeWhile(v -> !v.getName().startsWith("M"))
                .collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    static void dropWhileOperator(Stream<Videogame> stream){
        //take all  items after encounters the condition, we first order our items alphabetical a - z
        List<Videogame> r = stream
                .sorted(Comparator.comparing(Videogame::getName))
                .takeWhile(v -> !v.getName().startsWith("M"))
                .collect(Collectors.toList());
        r.forEach(System.out::println);
    }



}
