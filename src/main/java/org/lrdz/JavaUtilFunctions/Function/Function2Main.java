package org.lrdz.JavaUtilFunctions.Function;

import org.lrdz.UtilPojos.Person;

import java.io.*;
import java.util.Arrays;
import java.util.function.Function;

public class Function2Main {

    //EXAMPLE to serialize and deserialize a class.
    static Function<Person, ByteArrayOutputStream> serializer = p ->{
        ByteArrayOutputStream inMemoryBytes = new ByteArrayOutputStream();
        try(ObjectOutputStream outputStream = new ObjectOutputStream(inMemoryBytes)){
            outputStream.writeObject(p);
            outputStream.flush();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        return inMemoryBytes;
    };

    static Function<ByteArrayInputStream, Person> deserializer = bais ->{
        try(ObjectInputStream inputStream = new ObjectInputStream(bais)){
            return (Person) inputStream.readObject();
        }catch (IOException |  ClassNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }
    };

    public static void main(String[] args) {
        ByteArrayOutputStream outputStream = serializer.apply(new Person("Dani",232));
        System.out.println(Arrays.toString(outputStream.toByteArray()));

        Person objectDeserialized = deserializer.apply(new ByteArrayInputStream(outputStream.toByteArray()));
        System.out.println(objectDeserialized.toString());
    }

}
