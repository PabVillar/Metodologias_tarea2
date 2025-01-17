package model.items;

import model.units.*;
import model.units.IUnit;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractItem implements IEquipableItem {

  private final String name;
  private final int power;
  protected int maxRange;
  protected int minRange;
  private IUnit owner;

  /**
   * Constructor for a default item without any special behaviour.
   *
   * @param name
   *     the name of the item
   * @param power
   *     the power of the item (this could be the amount of damage or healing the item does)
   * @param minRange
   *     the minimum range of the item
   * @param maxRange
   *     the maximum range of the item
   */
  public AbstractItem(final String name, final int power, final int minRange, final int maxRange) {
    this.name = name;
    this.power = power;
    this.minRange = Math.max(minRange, 1);
    this.maxRange = Math.max(maxRange, this.minRange);
  }

  @Override
  public void equipTo(final IUnit unit) {
    unit.setEquippedItem(this);
    owner = unit;
  }


  @Override
  public IUnit getOwner() {
    return owner;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getPower() {
    return power;
  }

  @Override
  public int getMinRange() {
    return minRange;
  }

  @Override
  public int getMaxRange() {
    return maxRange;
  }

    @Override
    public int versusSword() {
        return 0;
    }

  @Override
  public int versusAxe() {
    return 0;
  }

  @Override
  public int versusBow() {
    return 0;
  }

  @Override
  public int versusSpear() {
    return 0;
  }

  @Override
  public int versusStaff() {
    return 0;
  }

  @Override
  public int versusLightMagicBook() {
    return 0;
  }

  @Override
  public int versusDarkMagicBook() {
    return 0;
  }

  @Override
  public int versusAenimaMagicBook() {
    return 0;
  }

  @Override
  public void equipToArcher(Archer archer){}

  @Override
  public void equipToCleric(Cleric cleric){}

  @Override
  public void equipToFighter(Fighter fighter){}

  @Override
  public void equipToHero(Hero hero){}

  @Override
  public void equipToSwordMaster(SwordMaster swordMaster){}

  @Override
  public void equipToSorcerer(Sorcerer sorcerer){}


}
