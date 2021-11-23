package ru.sfedu.library.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.library.entity.Student;

import java.util.*;

public class DataProviderCSVnew implements DataProviderNew{

    private static final Logger log = LogManager.getLogger(DataProviderCSVnew.class);


    private final Map<Integer, Student> students = new HashMap<>();

    @Override
    public Student create(Student student) {
        System.out.println("Creating user: " + student);
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public Student update(Student student) {
        System.out.println("Updating user: " + student);
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public void delete(int id) {
        System.out.println("Deleting user with id: " + id);
        students.remove(id);
    }

    @Override
    public Optional<Student> read(int id) {
        System.out.println("Retrieving user with id: " + id);
        return Optional.ofNullable(students.getOrDefault(id, null));
    }

    @Override
    public Collection<Student> get() {
        System.out.println("Retrieving all users");
        return students.values();
    }
}
