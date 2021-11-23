package ru.sfedu.library.api;

import ru.sfedu.library.entity.Student;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DataProviderNew {


    Student create(final Student student);

    Student update(final Student student);

    void delete(final int id);

    Optional<Student> read(final int id);

    Collection<Student> get();
}
