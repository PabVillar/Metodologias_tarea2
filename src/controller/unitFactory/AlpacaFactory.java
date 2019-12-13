package controller.unitFactory;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.Alpaca;
import model.units.IUnit;

public class AlpacaFactory extends UnitFactory{

    @Override
    public Alpaca create(int hitPoints, int movement, Location position, IEquipableItem... items) {
        return new Alpaca(hitPoints,movement,position,items);
    }
}
