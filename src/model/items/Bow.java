package model.items;

import model.units.Archer;
import model.units.Cleric;
import model.units.IUnit;

/**
 * @author Ignacio Slater Muñoz
 * @since
 */
public class Bow extends AbstractItem {



  /**
   * Creates a new bow.
   * <p>
   * Bows are weapons that can't attack adjacent units, so it's minimum range must me greater than
   * one.
   *
   * @param name
   *     the name of the bow
   * @param power
   *     the damage power of the bow
   * @param minRange
   *     the minimum range of the bow
   * @param maxRange
   *     the maximum range of the bow
   */
  public Bow(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
    this.minRange = Math.max(minRange, 2);
    this.maxRange = Math.max(maxRange, this.minRange);
  }

  @Override
  public int versusLightMagicBook() {
    return 1;
  }

  @Override
  public int versusDarkMagicBook() {
    return 1;
  }

  @Override
  public int versusAenimaMagicBook() {
    return 1;
  }

  @Override
  public int versus(IEquipableItem item) {
    return item.versusBow();
  }

  @Override
  public void equipToArcher(Archer archer){
    this.equipTo(archer);
  }


}
