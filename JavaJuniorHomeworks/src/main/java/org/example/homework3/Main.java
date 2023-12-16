package org.example.homework3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableCar bmw = new SerializableCar("BMW", "525i","2007", 258);

        String filename = SerializableCar.write(bmw);
        System.out.println(SerializableCar.read(filename));
    }


}
