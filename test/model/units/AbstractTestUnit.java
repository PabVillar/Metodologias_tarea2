package model.units;

import model.items.*;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractTestUnit implements ITestUnit {

  protected Alpaca targetAlpaca;
  protected Bow bow;
  protected Field field;
  protected Axe axe;
  protected Sword sword;
  protected Staff staff;
  protected Spear spear;
  protected LightMagicBook lightMagicBook;
  protected DarkMagicBook darkMagicBook;
  protected AenimaMagicBook aenimaMagicBook;

  @Override
  public void setTargetAlpaca() {
    targetAlpaca = new Alpaca(50, 2, field.getCell(1, 0));
  }

  /**
   * Sets up the units and weapons to be tested
   */
  @BeforeEach
  public void setUp() {
    setField();
    setTestUnit();
    setTargetAlpaca();
    setWeapons();
  }

  /**
   * Set up the game field
   */
  @Override
  public void setField() {
    this.field = new Field();
    this.field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
            new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
            new Location(2, 1), new Location(2, 2));
  }

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public abstract void setTestUnit();

  /**
   * Creates a set of testing weapons
   */
  @Override
  public void setWeapons() {
    this.axe = new Axe("Axe", 10, 1, 2);
    this.sword = new Sword("Sword", 10, 1, 2);
    this.spear = new Spear("Spear", 10, 1, 2);
    this.staff = new Staff("Staff", 10, 1, 2);
    this.bow = new Bow("Bow", 10, 2, 3);
  }

  /**
   * Checks that the constructor works properly.
   */
  @Override
  @Test
  public void constructorTest() {
    assertEquals(50, getTestUnit().getCurrentHitPoints());
    assertEquals(2, getTestUnit().getMovement());
    assertEquals(new Location(0, 0), getTestUnit().getLocation());
    assertTrue(getTestUnit().getItems().isEmpty());
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public abstract IUnit getTestUnit();

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Override
  @Test
  public void equipAxeTest() {
    assertNull(getTestUnit().getEquippedItem());
    checkEquippedItem(getAxe());
  }

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param item to be equipped
   */
  @Override
  public void checkEquippedItem(IEquipableItem item) {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipItem(item);
    assertNull(getTestUnit().getEquippedItem());
  }

  /**
   * @return the test axe
   */
  @Override
  public Axe getAxe() {
    return axe;
  }

  @Override
  @Test
  public void equipSwordTest() {
    checkEquippedItem(getSword());
  }

  /**
   * @return the test sword
   */
  @Override
  public Sword getSword() {
    return sword;
  }

  @Override
  @Test
  public void equipSpearTest() {
    checkEquippedItem(getSpear());
  }

  /**
   * @return the test spear
   */
  @Override
  public Spear getSpear() {
    return spear;
  }

  @Override
  @Test
  public void equipStaffTest() {
    checkEquippedItem(getStaff());
  }

  /**
   * @return the test staff
   */
  @Override
  public Staff getStaff() {
    return staff;
  }

  @Override
  @Test
  public void equipBowTest() {
    checkEquippedItem(getBow());
  }

  /**
   * @return the test bow
   */
  @Override
  public Bow getBow() {
    return bow;
  }

  /**
   * Checks if the unit moves correctly
   */
  @Override
  @Test
  public void testMovement() {
    getTestUnit().moveTo(getField().getCell(2, 2));
    assertEquals(new Location(0, 0), getTestUnit().getLocation());

    getTestUnit().moveTo(getField().getCell(0, 2));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());

    getField().getCell(0, 1).setUnit(getTargetAlpaca());
    getTestUnit().moveTo(getField().getCell(0, 1));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());
  }

  /**
   * @return the test field
   */
  @Override
  public Field getField() {
    return field;
  }

  /**
   * @return the target Alpaca
   */
  @Override
  public Alpaca getTargetAlpaca() {
    return targetAlpaca;
  }

  @Override
  public void equipLightMagicBookTest() {
    checkEquippedItem(getLightMagicBook());
  }


  @Override
  public LightMagicBook getLightMagicBook() {
    return lightMagicBook;
  }

  @Override
  public void equipDarkMagicBookTest() {
    checkEquippedItem(getDarkMagicBook());
  }

  @Override
  public DarkMagicBook getDarkMagicBook() {
    return darkMagicBook;
  }

  @Override
  public void equipAenimaMagicBookTest() {
    checkEquippedItem(getAenimaMagicBook());
  }

  @Override
  public AenimaMagicBook getAenimaMagicBook() {
    return aenimaMagicBook;
  }

  @Test
  @Override
  public void isAttackedByTest() {
    assertTrue(getTestUnit().isAttackedBy(new Archer(50,2,new Location(2,0))));
    assertTrue(getTestUnit().isAttackedBy(new Cleric(50,2,new Location(2,0))));
    assertTrue(getTestUnit().isAttackedBy(new Fighter(50,2,new Location(2,0))));
    assertTrue(getTestUnit().isAttackedBy(new Hero(50,2,new Location(2,0))));
    assertTrue(getTestUnit().isAttackedBy(new Sorcerer(50,2,new Location(2,0))));
    assertTrue(getTestUnit().isAttackedBy(new SwordMaster(50,2,new Location(2,0))));
  }


  @Override
  @Test
  public void attackTest() {

   Location location0 = new Location(0,0);
   Location location1 = new Location(0,1);
   Location location2 = new Location(1,0);
   Location location3 = new Location(1,1);
   Location location4 = new Location(0,2);
   Location location5 = new Location(2,0);

   location0.addNeighbour(location1);
   location0.addNeighbour(location2);
   location1.addNeighbour(location3);
   location1.addNeighbour(location4);
   location2.addNeighbour(location5);

   Archer archer = new Archer(50,2,location0);
   Cleric cleric = new Cleric(50,2,location1);
   Fighter fighter = new Fighter(50,2,location2);
   Hero hero = new Hero(50,2,location3);
   Sorcerer sorcerer = new Sorcerer(50,2,location4);
   SwordMaster swordMaster = new SwordMaster(50,2,location5);

   archer.equipItem(getBow());
   cleric.equipItem(getStaff());
   fighter.equipItem(getAxe());
   hero.equipItem(getSpear());
   sorcerer.equipItem(getAenimaMagicBook());
   swordMaster.equipItem(getSword());

   int bowPower = getBow().getPower();
   int staffPower = getStaff().getPower();
   int axePower = getAxe().getPower();
   int spearPower = getSpear().getPower();
   int aenimaPower = getAenimaMagicBook().getPower();
   int swordPower = getSword().getPower();

   cleric.attack(archer);
   assertEquals(50-bowPower,cleric.getCurrentHitPoints());

   fighter.attack(hero);
   assertEquals(50-spearPower+20,fighter.getCurrentHitPoints());

   sorcerer.attack(swordMaster);
   assertEquals(50-swordPower*1.5,sorcerer.getCurrentHitPoints());
  }
}
