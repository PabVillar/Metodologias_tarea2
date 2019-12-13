package controller.unitFactory;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.Cleric;
import model.units.IUnit;

public class ClericFactory extends UnitFactory{

    @Override
    public Cleric create(int hitPoints, int movement, Location position, IEquipableItem... items) {
        return new Cleric(hitPoints,movement,position,items);
    }
}
