package model.units;

import model.items.IEquipableItem;
import model.map.Location;

import java.util.List;

/**
 * This interface represents all units in the game.
 * <p>
 * The signature of all the common methods that a unit can execute are defined here. All units
 * except some special ones can carry at most 3 weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IUnit {

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   *     the item to equip
   */
  void equipItem(IEquipableItem item);

  /**
   * @return hit points of the unit
   */
  double getCurrentHitPoints();

  /**
   * sets current hit points of the unit
   */

  double setCurrentHitPoints(double hitPoints);

  /**
   * @return the items carried by this unit
   */
  List<IEquipableItem> getItems();

  /**
   * @return the currently equipped item
   */
  IEquipableItem getEquippedItem();

  void addItems(IEquipableItem item);

  /**
   * @param item
   *     the item to be equipped
   */
  void setEquippedItem(IEquipableItem item);

  /**
   * @return the current location of the unit
   */
  Location getLocation();

  /**
   * Sets a new location for this unit,
   */
  void setLocation(final Location location);

  /**
   * @return the number of cells this unit can move
   */
  int getMovement();

  /**
   * Moves this unit to another location.
   * <p>
   * If the other location is out of this unit's movement range, the unit doesn't move.
   */
  void moveTo(Location targetLocation);


  /**
   * A unit attacks to another unit
   */
  void attack(IUnit unit);

  /**
   *
   * @param unit
   */
  void isAttackedBy(IUnit unit);

  /**
   *
   * @return true if a unit has their hp > 0
   */
  boolean isActive();

  /**
   *
   * @return true if a unit can attack to another unit
   */
  boolean canAttack();

  /**
   * a Cleric can heal another unit
   * @param unit
   */
  void isHealedBy(IUnit unit);


  /**
   * a unit can give an item from their inventory to another unit
   * @param unit
   * @param item
   */
  void giveItemTo(IUnit unit, IEquipableItem item);

  /**
   * checks if a unit can receive an item
   * @return true if the inventory of the unit is full
   */
  boolean isFull();
}
