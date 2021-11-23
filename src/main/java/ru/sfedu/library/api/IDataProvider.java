package ru.sfedu.library.api;

import ru.sfedu.library.entity.User;
import ru.sfedu.library.entity.enums.Outcomes;

import java.util.Optional;

public interface IDataProvider {

    //
    // Other methods
    //

    /**
     */
    Outcomes createUser(User user);

    /**
     */
    Optional<User> getUserById(Long userId);

    /**
     */
    Outcomes updUser(User user);

    /**
     */
    Outcomes delUserById(Long userId);

}
