package model.items;

import model.map.Location;
import model.units.Cleric;
import model.units.IUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for staffs
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class StaffTest extends AbstractTestItem {

  private Staff staff;
  private Staff wrongStaff;
  private Cleric cleric;

  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    expectedName = "Common staff";
    expectedPower = 5;
    expectedMinRange = 1;
    expectedMaxRange = 1;
    staff = new Staff(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongStaff = new Staff("Wrong staff", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    cleric = new Cleric(10, 5, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongStaff;
  }

  /**
   * @return the item being tested
   */
  @Override
  public IEquipableItem getTestItem() {
    return staff;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return cleric;
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
