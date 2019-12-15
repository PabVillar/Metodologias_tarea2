package controller.factory.unitFactory;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.Alpaca;

public class AlpacaFactory extends UnitFactory{

    @Override
    public Alpaca create(int hitPoints, int movement, Location position, IEquipableItem... items) {
        return new Alpaca(hitPoints,movement,position,items);
    }
}
