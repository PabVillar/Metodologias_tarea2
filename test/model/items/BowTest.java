package model.items;

import model.map.Location;
import model.units.Archer;
import model.units.IUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test set for bows
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class BowTest extends AbstractTestItem {

  private Bow bow;
  private Bow wrongBow;
  private Archer archer;

  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    expectedName = "Common bow";
    expectedPower = 8;
    expectedMinRange = 2;
    expectedMaxRange = 4;
    bow = new Bow(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongBow = new Bow("Wrong bow", 10, 1, 1);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    archer = new Archer(10, 5, new Location(0, 0));
  }

  /**
   * Checks that the minimum range for a bow is greater than 1
   */
  @Override
  @Test
  public void incorrectRangeTest() {
    assertTrue(getWrongTestItem().getMinRange() > 1);
    assertTrue(getWrongTestItem().getMaxRange() >= getWrongTestItem().getMinRange());
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongBow;
  }

  /**
   * @return the item being tested
   */
  @Override
  public IEquipableItem getTestItem() {
    return bow;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return archer;
  }

  @Override
  public void versusTest() {
    assertEquals(0,getTestItem().versus(new Axe("axe",10,1,4)));
    assertEquals(0,getTestItem().versus(new Bow("bow",10,2,4)));
    assertEquals(0,getTestItem().versus(new Spear("spear",10,1,4)));
    assertEquals(0,getTestItem().versus(new Staff("staff",10,1,4)));
    assertEquals(0,getTestItem().versus(new Sword("sword",10,1,4)));

    assertEquals(1,getTestItem().versus(new AenimaMagicBook("aenimaBook",10,1,4)));
    assertEquals(1,getTestItem().versus(new DarkMagicBook("darkBook",10,1,4)));
    assertEquals(1,getTestItem().versus(new LightMagicBook("lightBook",10,1,4)));
  }
}
