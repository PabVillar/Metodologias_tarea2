package controller.factory.unitFactory;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.Fighter;

public class FighterFactory extends UnitFactory {
    @Override
    public Fighter create(int hitPoints, int movement, Location position, IEquipableItem... items) {
        return new Fighter(hitPoints,movement,position,items);
    }
}
