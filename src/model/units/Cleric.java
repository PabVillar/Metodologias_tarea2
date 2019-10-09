package model.units;

import model.items.IEquipableItem;
import model.items.Staff;
import model.map.Location;

/**
 * This class represents a cleric type unit. A cleric can only use staff type weapons, which means
 * that it can receive attacks but can't counter attack any of those.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Cleric extends AbstractUnit {

  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   */
  public Cleric(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   *     the item to equip
   */
  @Override
  public void equipItem(final IEquipableItem item) {
    if (item instanceof Staff) {
      equippedItem = item;
    }
  }

  @Override
  public void attack(IUnit unit) {
    int minRange = this.getEquippedItem().getMinRange();
    int maxRange = this.getEquippedItem().getMaxRange();

    double thisRange = this.getLocation().distanceTo(unit.getLocation());


    if (thisRange <= maxRange && thisRange >=minRange){
      if (this.getEquippedItem() != null && unit.getEquippedItem() != null && this.isActive() && unit.isActive()){
        unit.isHealedBy(this);

        int unitMinRange = unit.getEquippedItem().getMinRange();
        int unitMaxRange = unit.getEquippedItem().getMaxRange();

        double unitRange = unit.getLocation().distanceTo(this.getLocation());
        if(unit.isActive() && unit.canAttack()){
          if (unitRange <= unitMaxRange && unitRange >= unitMinRange){
            this.isAttackedBy(unit);

          }


        }
      }

    }

  }
}
