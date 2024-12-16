package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddingAppTest {

    @Test
    void testAddingApp() {
        AddingApp addingApp = new AddingApp();
        assertEquals(5, addingApp.add(2, 3));
    }

}