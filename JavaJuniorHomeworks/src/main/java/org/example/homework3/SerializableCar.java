package org.example.homework3;

import java.io.*;
import java.nio.file.Files;
import java.util.UUID;

public class SerializableCar implements Serializable {
    private String name;
    private String model;
    private String year;
    private int horsePower;

    public SerializableCar(String name, String model, String year, int horsePower) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.horsePower = horsePower;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return String.format(" Name = %s\n " +
                "model = %s\n " +
                "year = %s\n " +
                "horse powers = %d hp\n", name,model,year,horsePower);
    }

    public static String write(Serializable object) throws IOException {
        String filename = object.getClass() + "_" + UUID.randomUUID().toString() + ".txt";
        File file = new File(filename);
        if(!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        return filename;
    }

    public static Serializable read(String filename) throws IOException, ClassNotFoundException {
        File file = new File(filename);
        if(!file.exists()) {
            return null;
        } else {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Serializable object = (Serializable) objectInputStream.readObject();
            objectInputStream.close();
            file.delete();
            return (object);
        }
    }
}
