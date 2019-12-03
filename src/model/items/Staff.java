package model.items;

import model.units.Archer;
import model.units.Cleric;

/**
 * This class represents a <i>Staff</i> type item.
 * <p>
 * A staff is an item that can heal other units nut cannot counter any attack
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Staff extends AbstractItem {

  /**
   * Creates a new Staff item.
   *
   * @param name
   *     the name of the staff
   * @param power
   *     the healing power of the staff
   * @param minRange
   *     the minimum range of the staff
   * @param maxRange
   *     the maximum range of the staff
   */
  public Staff(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
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
  public int versus(IEquipableItem item) {
    return item.versusStaff();
  }

  @Override
  public void equipToCleric(Cleric cleric){
    this.equipTo(cleric);
  }
}
