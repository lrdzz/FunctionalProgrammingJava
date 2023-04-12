package org.lrdz.JavaUtilFunctions.Supplier;

import org.lrdz.UtilPojos.MyProduct;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierMain {
    //its the opposite of the consumer interface
    static Supplier<Integer> randomInt = () -> new Random().nextInt(100);
    static Supplier<MyProduct> productSupplier = () -> new MyProduct(100,"name");
    public static void main(String[] args) {
        System.out.println(randomInt.get());
        System.out.println(randomInt.get());
        System.out.println(productSupplier.get());
    }
}
