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
    this.axe = new Axe("Axe", 30, 1, 3);
    this.sword = new Sword("Sword", 30, 1, 3);
    this.spear = new Spear("Spear", 30, 1, 3);
    this.staff = new Staff("Staff", 30, 1, 3);
    this.bow = new Bow("Bow", 30, 2, 4);
    this.aenimaMagicBook = new AenimaMagicBook("AenimaMagicBook",30,1,3);
    this.darkMagicBook = new DarkMagicBook("DarkMagicBook",30,1,3);
    this.lightMagicBook = new LightMagicBook("LightMagicBook",30,1,3);
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
   * @return the test fieldSí. Por lo que tengo entendido, corresponde al quórum que se establece para plebiscitos en la facultad
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
  @Test
  public void equipLightMagicBookTest() {
    checkEquippedItem(getLightMagicBook());
  }

    /**
     *
     * @return the test light magic book
     */
  @Override
  public LightMagicBook getLightMagicBook() {
    return lightMagicBook;
  }

  @Override
  @Test
  public void equipDarkMagicBookTest() {
    checkEquippedItem(getDarkMagicBook());
  }

    /**
     *
     * @return the test dark magic book
     */
  @Override
  public DarkMagicBook getDarkMagicBook() {
    return darkMagicBook;
  }

  @Override
  @Test
  public void equipAenimaMagicBookTest() {
    checkEquippedItem(getAenimaMagicBook());
  }

    /**
     *
     * @return the test aenima magic book
     */
  @Override
  public AenimaMagicBook getAenimaMagicBook() {
    return aenimaMagicBook;
  }

    /**
     * Checks if units attack correctly
     * Cleric just can heal another unit
     */
  @Override
  @Test
  public void attackTest() {

    Location l0 = new Location(0,0);
    Location l1 = new Location(0,1);
    Location l2 = new Location(1,0);
    Location l3 = new Location(0,2);
    Location l4 = new Location(2,0);
    Location l5 = new Location(2,2);
    Location l6 = new Location(0,3);
    Location l7 = new Location(3,0);
    Location l8 = new Location(3,3);

    l0.addNeighbour(l1);
    l0.addNeighbour(l2);
    l1.addNeighbour(l3);
    l2.addNeighbour(l4);
    l3.addNeighbour(l5);
    l4.addNeighbour(l5);
    l3.addNeighbour(l6);
    l5.addNeighbour(l7);
    l6.addNeighbour(l8);
    l7.addNeighbour(l8);



    int axePower = axe.getPower();
    int bowPower = bow.getPower();
    int aenimaMagicBookPower = aenimaMagicBook.getPower();
    int darkMagicBookPower = darkMagicBook.getPower();
    int lightMagicBookPower = lightMagicBook.getPower();
    int spearPower = spear.getPower();
    int staffPower = staff.getPower();
    int swordPower = sword.getPower();


    Alpaca alpaca = new Alpaca(50,2,l0);
    Archer archer = new Archer(50,2,l0);
    Cleric cleric = new Cleric(50,2,l2);
    Fighter fighter = new Fighter(50,2,l3);
    Hero hero = new Hero(50,2,l4);
    Sorcerer sorcerer_1 = new Sorcerer(50,2,l5);
    Sorcerer sorcerer_2 = new Sorcerer(50,2,l6);
    Sorcerer sorcerer_3 = new Sorcerer(50,2,l7);
    SwordMaster swordMaster = new SwordMaster(50,2,l8);

    archer.equipItem(getBow());
    cleric.equipItem(getStaff());
    fighter.equipItem(getAxe());
    hero.equipItem(getSpear());
    sorcerer_1.equipItem(getAenimaMagicBook());
    sorcerer_2.equipItem(getDarkMagicBook());
    sorcerer_3.equipItem(getLightMagicBook());
    swordMaster.equipItem(getSword());

    //fighter vs hero
    fighter.attack(hero);
    assertEquals(50-axePower*1.5, hero.getCurrentHitPoints());
    assertEquals(50-axePower+20, fighter.getCurrentHitPoints());

    //archer vs sorcerer_1
    archer.attack(sorcerer_1);
    assertEquals(50-bowPower+20, sorcerer_1.getCurrentHitPoints());
    assertEquals(50-aenimaMagicBookPower+20, archer.getCurrentHitPoints());

    //sorcerer_2 vs sorcerer_3
    sorcerer_2.attack(sorcerer_3);
    assertEquals(50-darkMagicBookPower*1.5, sorcerer_3.getCurrentHitPoints());
    assertEquals(50-lightMagicBookPower+20, sorcerer_2.getCurrentHitPoints());

    //alpaca vs cleric
    cleric.attack(alpaca);
    assertEquals(50,alpaca.getCurrentHitPoints());
    assertEquals(50,cleric.getCurrentHitPoints());


  }

    /**
     * Checks if a item was correctly added to the inventory
     */
    @Test
    @Override
    public void addItemsToInventory(){
      Archer archer = new Archer(50,2,new Location(0,0));

      assertTrue(archer.getItems().isEmpty());

      archer.addItems(bow);

      assertTrue(archer.getItems().contains(bow));
    }

    /**
     * Checks if a unit can correctly give an item to another unit
     */
    @Test
    @Override
    public void giveItemTo(){
      Location l0 = new Location(0,0);
      Location l1 = new Location(0,1);

      l0.addNeighbour(l1);

      Archer archer = new Archer(50,2,l0);
      Sorcerer sorcerer = new Sorcerer(50,2,l1);

      Bow bow = new Bow("bow",30,2,4);


      archer.addItems(bow);

      archer.giveItemTo(sorcerer,bow);
      assertFalse(archer.items.contains(bow));
      assertTrue(sorcerer.items.contains(bow));

  }
}


