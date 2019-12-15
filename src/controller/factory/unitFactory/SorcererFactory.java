package controller.factory.unitFactory;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.Sorcerer;

public class SorcererFactory extends UnitFactory {
    @Override
    public Sorcerer create(int hitPoints, int movement, Location position, IEquipableItem... items) {
        return new Sorcerer(hitPoints,movement,position,items);
    }
}
