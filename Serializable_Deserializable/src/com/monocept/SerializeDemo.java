package com.monocept;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class SerializeDemo {

    public static void main(String[] args) {

        Student s1 = new Student(101, "Raushan");

        try {
            FileOutputStream fos = new FileOutputStream("C:\\Java Monocept\\Serializable_Deserializable\\src\\com\\monocept\\student.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(s1);

            oos.close();
            fos.close();

            System.out.println("Object Serialized Successfully");

        } catch (IOException e) {
            System.out.println("Error during Serialization: " + e.getMessage());
        }
    }
}
