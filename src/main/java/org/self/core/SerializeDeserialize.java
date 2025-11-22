package org.self.core;

import lombok.*;

import java.io.*;

@Getter
@Setter
@AllArgsConstructor
class Student implements Serializable {
//    private static final long serialVersionUID = 3L;
    private String username;
    private String password;
    private int age;
    private Long phoneNumber;

    private String newField;
}

public class SerializeDeserialize {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Student student = new Student("sba", "rf", 1, 34545L);
//        serialize(student);

        deserialize();
    }

    private static void deserialize() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("object.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Student student = (Student) objectInputStream.readObject();

        System.out.println("student name: " + student.getUsername());
        System.out.println("student pwd: " + student.getPassword());

        System.out.println("student age: " + student.getAge());
        System.out.println("phone number: " + student.getPhoneNumber());

        objectInputStream.close();
        fileInputStream.close();
    }

    public static void serialize(Student student) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("object.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student);

        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("done");
    }
}
