package model.items;

import model.map.Location;
import model.units.Fighter;
import model.units.IUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for Axes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
class AxeTest extends AbstractTestItem {

  private Axe axe;
  private Axe wrongAxe;
  private Fighter fighter;

  @Override
  public void setTestItem() {
    expectedName = "Common axe";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 2;
    axe = new Axe(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongAxe = new Axe("Wrong axe", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    fighter = new Fighter(10, 5, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongAxe;
  }

  @Override
  public IEquipableItem getTestItem() {
    return axe;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return fighter;
  }

  @Override
  public void versusTest() {
    assertEquals(0,getTestItem().versus(new Axe("axe",10,1,4)));
    assertEquals(0,getTestItem().versus(new Bow("bow",10,2,4)));
    assertEquals(1,getTestItem().versus(new Spear("spear",10,1,4)));
    assertEquals(0,getTestItem().versus(new Staff("staff",10,1,4)));
    assertEquals(-1,getTestItem().versus(new Sword("sword",10,1,4)));

    assertEquals(1,getTestItem().versus(new AenimaMagicBook("aenimaBook",10,1,4)));
    assertEquals(1,getTestItem().versus(new DarkMagicBook("darkBook",10,1,4)));
    assertEquals(1,getTestItem().versus(new LightMagicBook("lightBook",10,1,4)));
  }
}