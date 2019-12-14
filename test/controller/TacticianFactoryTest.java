package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import controller.tacticianFactory.TacticianFactory;

import model.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.IUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TacticianFactoryTest {
    private TacticianFactory tacticianFactory;

    @BeforeEach
    void setUp(){
        tacticianFactory = new TacticianFactory();
        tacticianFactory.setName(0);
    }

    @Test
    public void createTacticianTest(){
        Tactician tactician1 = tacticianFactory.getTactician("Player 0");
        tacticianFactory.setName(1);
        Tactician tactician2 = tacticianFactory.getTactician("Player 1");

        assertEquals(Tactician.class,tactician1.getClass());
        assertEquals(Tactician.class,tactician2.getClass());

        assertEquals("Player 0",tactician1.getName());
        assertEquals("Player 1", tactician2.getName());


    }



}
