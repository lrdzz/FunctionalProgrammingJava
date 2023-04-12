package org.lrdz.ObjectMethodReference;

import org.lrdz.UtilPojos.MyObject;

import java.util.function.Supplier;

public class ConstructorMethodReference {
    public static void main(String[] args) {
        ///lambda mode
        // Supplier<MyObject> newMyObject = () -> new MyObject();
        Supplier<MyObject> newMyObject = MyObject::new;
        System.out.println(newMyObject.get());
    }
}