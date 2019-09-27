package model.units;

import model.map.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SorcererTest extends AbstractTestUnit{

    private Sorcerer sorcerer;


    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(50,2,new Location(0,0));
    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }

    @Override
    public void testMovement() {
        super.testMovement();
    }

    @Override
    public void equipLightMagicBookTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipItem(lightMagicBook);
        assertEquals(lightMagicBook, sorcerer.getEquippedItem());
    }

    @Override
    public void equipDarkMagicBookTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipItem(darkMagicBook);
        assertEquals(darkMagicBook, sorcerer.getEquippedItem());
    }


    @Override
    public void equipAenimaMagicBookTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipItem(aenimaMagicBook);
        assertEquals(aenimaMagicBook, sorcerer.getEquippedItem());
    }

    @Override
    public void isAttackedByTest() {
        super.isAttackedByTest();
    }

    @Override
    @Test
    public void attackTest() {
        super.attackTest();
    }
}
