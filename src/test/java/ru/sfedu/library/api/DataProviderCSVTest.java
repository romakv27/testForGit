package ru.sfedu.library.api;

import org.junit.jupiter.api.Test;
import ru.sfedu.library.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sfedu.library.entity.enums.Outcomes.OK;

class DataProviderCSVTest {
    final IDataProvider provider = new DataProviderCSV();

    @Test
    public void crudUser() {

        assertFalse(provider.getUserById(2L).isPresent());

        assertEquals(provider.createUser(new User(2L, "Pavel", "Ivanov", 18)), OK);
        assertNotEquals(provider.createUser(new User(2L, "Pavel", "Ivanov", 18)), OK);

        assertTrue(provider.getUserById(2L).isPresent());
        assertEquals(provider.updUser(new User(2L, "Pavel", "Ivanov", 22)), OK);


        //  assertEquals(provider.getUserById(1L).get().getAge(), 21, 0);
        //assertEquals(provider.delUserById(1L), OK);
    }
}