package model.items;

import model.map.Location;
import model.units.IUnit;
import model.units.Sorcerer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LightMagicBookTest extends AbstractTestItem {
    private MagicBook lightMagicBook;
    private MagicBook wrongLightMagicBook;
    private Sorcerer sorcerer;

    /**
     * Sets which item is going to be tested
     */
    @Override
    public void setTestItem() {
        expectedName = "Light magic book";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 4;
        lightMagicBook = new LightMagicBook(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongLightMagicBook = new LightMagicBook("Wrong light magic book",10,1,1);
    }

    /**
     * Sets the unit that will be equipped with the test item
     */
    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(50,2,new Location(0,0));
    }

    @Override
    public IEquipableItem getWrongTestItem() {
        return wrongLightMagicBook;
    }

    /**
     * @return the item being tested
     */
    @Override
    public IEquipableItem getTestItem() {
        return lightMagicBook;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }

    @Override
    public void versusTest() {
        assertEquals(1,getTestItem().versus(new Axe("axe",10,1,4)));
        assertEquals(1,getTestItem().versus(new Bow("bow",10,2,4)));
        assertEquals(1,getTestItem().versus(new Spear("spear",10,1,4)));
        assertEquals(1,getTestItem().versus(new Staff("staff",10,1,4)));
        assertEquals(1,getTestItem().versus(new Sword("sword",10,1,4)));

        assertEquals(-1,getTestItem().versus(new AenimaMagicBook("aenimaBook",10,1,4)));
        assertEquals(1,getTestItem().versus(new DarkMagicBook("darkBook",10,1,4)));
        assertEquals(0,getTestItem().versus(new LightMagicBook("lightBook",10,1,4)));
    }
}
