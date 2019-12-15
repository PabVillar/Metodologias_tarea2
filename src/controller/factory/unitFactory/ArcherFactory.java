package controller.factory.unitFactory;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.Archer;

public class ArcherFactory extends UnitFactory {

    @Override
    public Archer create(int hitPoints, int movement, Location position, IEquipableItem... items) {
        return new Archer(hitPoints,movement,position,items);
    }
}
