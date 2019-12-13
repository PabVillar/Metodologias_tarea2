package controller.unitFactory;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.Archer;
import model.units.IUnit;

public class ArcherFactory extends UnitFactory {

    @Override
    public Archer create(int hitPoints, int movement, Location position, IEquipableItem... items) {
        return new Archer(hitPoints,movement,position,items);
    }
}
