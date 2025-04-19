package org.example.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    private Menu menu;

    @BeforeEach
    void testDependenciesSetup(){
        menu = new Menu();
    }

    @Test
    public void checkIfGetMenuOptionGetsCorrectValues() throws IOException {
        String option = "1";
        ByteArrayInputStream in = new ByteArrayInputStream(option.getBytes());
        System.setIn(in);
        assertEquals(option, menu.getMenuOption().toString());
    }


}