package org.lrdz.Lambdas;

import org.lrdz.FunctionalInterface.IMath;
import org.lrdz.FunctionalInterface.IPrinter;
import org.lrdz.UtilPojos.Employee;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IMath sum = new IMath() {
            @Override
            public Double excecute(Double a, Double b) {
                return a + b;
            }
        };
        System.out.println(sum.excecute(4.0,3.0));
        //another way to generate a lambda expression.
        IMath multiply = (a, b) -> a*b;
        System.out.println(multiply.excecute(1.0,33.0));

        IMath divide = (Double a, Double b) -> a/b;
        System.out.println(divide.excecute(13.0,11.0));


        /////////////// using the generic interface

        IPrinter<String> printStringUppercase = string -> System.out.println(string.toUpperCase());
        printStringUppercase.print("hoLa eQUIsde");

        ///// using the util pojo.
        IPrinter<Employee> printEmployee = emmployee -> System.out.println(emmployee.toString());

        Employee employee = new Employee();
        employee.setDni("dni");

        printEmployee.print(employee);


        ////////////// using variable outside the lambda scope
        //we must declare an atomic variabnle because using the lambdas this variable may be in various threads so by this, we convert this to a volatile variable (can be in multiple threats).
        AtomicInteger num = new AtomicInteger(10);
        //AtomicReference<Employee>  ... this is the way to make an object atomic.
        IntStream.range(1,10).forEach(i -> num.set(num.get()+i)); // this is an interface to process x times a thing.
        System.out.println(num.get());
    }
}
