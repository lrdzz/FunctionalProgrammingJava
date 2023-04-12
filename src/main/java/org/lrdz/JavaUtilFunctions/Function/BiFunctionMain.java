package org.lrdz.JavaUtilFunctions.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class BiFunctionMain {

    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Miami","Mexico");
        List<Integer> population = Arrays.asList(11111111,32312312);
        List<String> stringsResult = listCombiner(cities, population, (a, b) -> a + " has " + b + " citizens");
        System.out.println(stringsResult);
    }


    ///creating a function to combine 2 list , acording to the bifunction parameter.
    private static<T,U,R> List<R> listCombiner(List<T> list1, List<U> list2, BiFunction<T,U,R> combiner){
        List<R> result = new ArrayList<>();
        for(int i = 0 ; i < list1.size(); i++){
            result.add(combiner.apply(list1.get(i), list2.get(i)));
        }
        return result;
    }
}
