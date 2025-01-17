package controller.factory.unitFactory;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.Hero;

public class HeroFactory extends UnitFactory {

    @Override
    public Hero create(int hitPoints, int movement, Location position, IEquipableItem... items) {
        return new Hero(hitPoints,movement,position,items);
    }
}
