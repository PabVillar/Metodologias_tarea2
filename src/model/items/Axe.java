package model.items;

import model.units.Fighter;

/**
 * This class represents an Axe.
 * <p>
 * Axes are strong against spears but weak agains swords.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Axe extends AbstractItem {

  /**
   * Creates a new Axe item
   *
   * @param name
   *     the name of the Axe
   * @param power
   *     the damage of the axe
   * @param minRange
   *     the minimum range of the axe
   * @param maxRange
   *     the maximum range of the axe
   */
  public Axe(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  @Override
  public int versusSword() {
    return 1;
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
    return -1;
  }

  @Override
  public int versusStaff() {
    return 0;
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
    return item.versusAxe();
  }

  @Override
  public void equipToFighter(Fighter fighter){
    this.equipTo(fighter);
  }
}
