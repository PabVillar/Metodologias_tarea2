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
   * @param hitPoints the maximum amount of damage a unit can sustain
   * @param movement  the number of panels a unit can move
   * @param location  the current position of this unit on the map
   * @param maxItems  maximum amount of items this unit can carry
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
  public void addItems(IEquipableItem item){this.items.add(item);}

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
  public boolean isActive() {
    if (this.getCurrentHitPoints() != 0) {
      return true;
    }
    return false;
  }

  @Override
  public boolean canAttack() {
    return true;
  }

  @Override
  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
            && targetLocation.getUnit() == null) {
      setLocation(targetLocation);
    }
  }

  @Override
  public void attack(IUnit unit) {
    int minRange = this.getEquippedItem().getMinRange();
    int maxRange = this.getEquippedItem().getMaxRange();

    double thisRange = this.getLocation().distanceTo(unit.getLocation());


    if (thisRange <= maxRange && thisRange >= minRange) {
      if (this.getEquippedItem() != null && unit.getEquippedItem() != null && this.isActive() && unit.isActive()) {
        unit.isAttackedBy(this);

        int unitMinRange = unit.getEquippedItem().getMinRange();
        int unitMaxRange = unit.getEquippedItem().getMaxRange();

        double unitRange = unit.getLocation().distanceTo(this.getLocation());
        if (unit.isActive() && unit.canAttack()) {
          if (unitRange <= unitMaxRange && unitRange >= unitMinRange) {
            this.isAttackedBy(unit);

          }


        }
      }

    }

  }

  @Override
  public void isAttackedBy(IUnit attacker) {
    int attackerPower = attacker.getEquippedItem().getPower();
    if (this.getEquippedItem() != null) {
      switch (this.getEquippedItem().versus(attacker.getEquippedItem())) {
        case 0:
          this.setCurrentHitPoints(getCurrentHitPoints() - attackerPower);
          break;
        case 1:
          if (attackerPower >= 20) {
            this.setCurrentHitPoints(getCurrentHitPoints() - attackerPower + 20);
            break;
          }
          break;
        case -1:
          this.setCurrentHitPoints(getCurrentHitPoints() - attackerPower * 1.5);
          break;
      }
    } else {
      this.setCurrentHitPoints(getCurrentHitPoints() - attackerPower);
    }

  }

  @Override
  public void isHealedBy(IUnit unit) {
    int healPower = unit.getEquippedItem().getPower();
    this.setCurrentHitPoints(getCurrentHitPoints() + healPower);
  }

  @Override
  public void giveItemTo(IUnit unit, IEquipableItem item) {

    double thisRange = this.getLocation().distanceTo(unit.getLocation());

    if (thisRange == 1 && this.getItems() != null && !unit.isFull()) {
      int index = this.getItems().indexOf(item);
      IEquipableItem itemToGive = this.getItems().get(index);
      unit.addItems(itemToGive);
      this.items.remove(itemToGive);
    }


  }

  @Override
  public boolean isFull() {
    boolean isFull = false;
    for (int i = 0; i < this.items.size(); ++i) {
      if (this.items.get(i) != null) {
        isFull = true;
      }
      else {
        isFull = false;
        break;
      }
    }
    return isFull;
  }
}

