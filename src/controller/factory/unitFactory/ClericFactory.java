package controller.factory.unitFactory;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.Cleric;

public class ClericFactory extends UnitFactory{

    @Override
    public Cleric create(int hitPoints, int movement, Location position, IEquipableItem... items) {
        return new Cleric(hitPoints,movement,position,items);
    }
}
