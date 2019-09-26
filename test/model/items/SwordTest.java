package model.items;

import model.map.Location;
import model.units.IUnit;
import model.units.SwordMaster;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for swords
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class SwordTest extends AbstractTestItem {

  private Sword sword;
  private Sword wrongSword;
  private SwordMaster swordMaster;

  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    expectedName = "Common sword";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 1;
    sword = new Sword(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongSword = new Sword("Wrong sword", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    swordMaster = new SwordMaster(10, 5, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongSword;
  }

  /**
   * @return the item being tested
   */
  @Override
  public IEquipableItem getTestItem() {
    return sword;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return swordMaster;
  }

  @Override
  public void versusTest() {
    assertEquals(1,getTestItem().versus(new Axe("axe",10,1,4)));
    assertEquals(0,getTestItem().versus(new Bow("bow",10,2,4)));
    assertEquals(-1,getTestItem().versus(new Spear("spear",10,1,4)));
    assertEquals(0,getTestItem().versus(new Staff("staff",10,1,4)));
    assertEquals(0,getTestItem().versus(new Sword("sword",10,1,4)));

    assertEquals(1,getTestItem().versus(new AenimaMagicBook("aenimaBook",10,1,4)));
    assertEquals(1,getTestItem().versus(new DarkMagicBook("darkBook",10,1,4)));
    assertEquals(1,getTestItem().versus(new LightMagicBook("lightBook",10,1,4)));
  }
}
