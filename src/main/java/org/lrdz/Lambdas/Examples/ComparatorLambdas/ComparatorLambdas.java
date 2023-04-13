package org.lrdz.Lambdas.Examples.ComparatorLambdas;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambdas {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 65, 1, 55, 33, 2);
        //sort ascending
        numbers.sort((a,b) -> a-b);
        System.out.println(numbers);

        List<String> names = Arrays.asList("pepe","maria","jesus","luisa");
        //names.sort((a,b) -> a.compareTo(b));
        names.sort(String::compareTo); // order ascending, alphabetic order.
        System.out.println("ascending " + names);
        names.sort(Comparator.reverseOrder()); // descending alphabetic order.
        System.out.println("descending " + names);

        ////////////// Comparing objects
        List<PersonX> personXList = Arrays.asList(new PersonX("pepe", 123), new PersonX("juan", 345), new PersonX("marta", 13));
        personXList.sort(Comparator.comparingInt(PersonX::getAge)); // order ascending by age
        System.out.println(personXList);

        List<PersonX> personXList2 = Arrays.asList(new PersonX("pepe", 123), new PersonX("juan", 345), new PersonX("marta", 13), new PersonX("karla",123));
        personXList2.sort(Comparator.comparingInt(PersonX::getAge).thenComparing(PersonX::getName)); // order ascending by age and name if 2 elementes havee same age.
        System.out.println(personXList2);
    }
}

@Data
@AllArgsConstructor
class PersonX {
    private String name;
    private Integer age;
}
