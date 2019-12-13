package model.units;

import model.items.IEquipableItem;
import model.map.Location;

import java.util.List;

public class NullUnit implements IUnit{

    /**
     * Creates a null unit.
     */
    public IUnit NullUnit() {
        return null;
    }

    @Override
    public void equipItem(IEquipableItem item) {

    }

    @Override
    public double getCurrentHitPoints() {
        return 0;
    }

    @Override
    public double setCurrentHitPoints(double hitPoints) {
        return 0;
    }

    @Override
    public List<IEquipableItem> getItems() {
        return null;
    }

    @Override
    public IEquipableItem getEquippedItem() {
        return null;
    }

    @Override
    public void addItems(IEquipableItem item) {

    }

    @Override
    public void setEquippedItem(IEquipableItem item) {

    }

    @Override
    public Location getLocation() {
        return null;
    }

    @Override
    public void setLocation(Location location) {

    }

    @Override
    public int getMovement() {
        return 0;
    }

    @Override
    public void moveTo(Location targetLocation) {

    }

    @Override
    public void attack(IUnit unit) {

    }

    @Override
    public void isAttackedBy(IUnit unit) {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public void isHealedBy(IUnit unit) {

    }

    @Override
    public void giveItemTo(IUnit unit, IEquipableItem item) {

    }

    @Override
    public boolean isFull() {
        return false;
    }
}
