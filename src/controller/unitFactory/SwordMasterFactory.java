package controller.unitFactory;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.IUnit;
import model.units.SwordMaster;

public class SwordMasterFactory extends UnitFactory {
    @Override
    public SwordMaster create(int hitPoints, int movement, Location position, IEquipableItem... items) {
        return new SwordMaster(hitPoints,movement,position,items);
    }
}
