package model.units;

import model.items.IEquipableItem;
import model.map.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.min;

/**
 * This class represents an abstract unit.
 * <p>
 * An abstract unit is a unit that cannot be used in the
 * game, but that contains the implementation of some of the methods that are common for most
 * units.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractUnit implements IUnit {

  protected final List<IEquipableItem> items = new ArrayList<>();
  private double currentHitPoints;
  private final int movement;
  protected IEquipableItem equippedItem;
  private Location location;

  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   * @param location
   *     the current position of this unit on the map
   * @param maxItems
   *     maximum amount of items this unit can carry
   */
  protected AbstractUnit(final double hitPoints, final int movement,
      final Location location, final int maxItems, final IEquipableItem... items) {
    this.currentHitPoints = hitPoints;
    this.movement = movement;
    this.location = location;
    this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
  }

  @Override
  public double getCurrentHitPoints() {
    return currentHitPoints;
  }

  @Override
  public double setCurrentHitPoints(double hitPoints) {
    return this.currentHitPoints = hitPoints;
  }

  @Override
  public List<IEquipableItem> getItems() {
    return List.copyOf(items);
  }

  @Override
  public IEquipableItem getEquippedItem() {
    return equippedItem;
  }

  @Override
  public void setEquippedItem(final IEquipableItem item) {
    this.equippedItem = item;
  }

  @Override
  public Location getLocation() {
    return location;
  }

  @Override
  public void setLocation(final Location location) {
    this.location = location;
  }

  @Override
  public int getMovement() {
    return movement;
  }

  @Override
  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
        && targetLocation.getUnit() == null) {
      setLocation(targetLocation);
    }
  }

  @Override
  public boolean isAttackedBy(IUnit unit) {
    if(unit.getLocation().distanceTo(this.getLocation()) <= unit.getEquippedItem().getMaxRange() && unit.getLocation().distanceTo(this.getLocation()) >=unit.getEquippedItem().getMinRange()){
      if(unit.getEquippedItem() != null && this.getEquippedItem()!= null){
        return true;
      }

    }
    return false;
  }

  @Override
  public double combat(IUnit unit) {
    double currentHP = this.currentHitPoints;
    if (this.isAttackedBy(unit)) {
      if (this.getEquippedItem().versus(unit.getEquippedItem()) == 0) {
        currentHP = this.getCurrentHitPoints() - unit.getEquippedItem().getPower();
      }
      else if(this.getEquippedItem().versus(unit.getEquippedItem()) == -1) {
        currentHP = this.getCurrentHitPoints() - (unit.getEquippedItem().getPower() * 1.5);
      }
      else if (this.getEquippedItem().versus(unit.getEquippedItem()) == 1){
        currentHP = this.getCurrentHitPoints() - unit.getEquippedItem().getPower() + 20;
      }
    }
    return this.setCurrentHitPoints(currentHP);
  }

}
