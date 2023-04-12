package org.lrdz.ObjectMethodReference;

import java.util.UUID;
import java.util.function.Supplier;

public class StaticMethodReference {
    public static void main(String[] args) {
        //supplier is a functional interface, UUID is a static class.
        //lambda
        /////Supplier<UUID> getToken = () ->UUID.randomUUID();
        //static method reference
        Supplier<UUID> getToken = UUID::randomUUID;
        System.out.println(getToken.get());
    }
}
