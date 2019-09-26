package model.items;

import model.map.Location;
import model.units.Hero;
import model.units.IUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for spears
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class SpearTest extends AbstractTestItem {

  private Spear javelin;
  private Spear wrongSpear;
  private Hero hero;

  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    expectedName = "Javelin";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 3;
    javelin = new Spear(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongSpear = new Spear("Wrong spear", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    hero = new Hero(10, 5, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongSpear;
  }

  /**
   * @return the item being tested
   */
  @Override
  public IEquipableItem getTestItem() {
    return javelin;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return hero;
  }

  @Override
  public void versusTest() {
    assertEquals(-1,getTestItem().versus(new Axe("axe",10,1,4)));
    assertEquals(0,getTestItem().versus(new Bow("bow",10,2,4)));
    assertEquals(0,getTestItem().versus(new Spear("spear",10,1,4)));
    assertEquals(0,getTestItem().versus(new Staff("staff",10,1,4)));
    assertEquals(1,getTestItem().versus(new Sword("sword",10,1,4)));

    assertEquals(1,getTestItem().versus(new AenimaMagicBook("aenimaBook",10,1,4)));
    assertEquals(1,getTestItem().versus(new DarkMagicBook("darkBook",10,1,4)));
    assertEquals(1,getTestItem().versus(new LightMagicBook("lightBook",10,1,4)));
  }
}
