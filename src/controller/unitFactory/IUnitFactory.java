package controller.unitFactory;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.IUnit;

public interface IUnitFactory {

    IUnit create(final int hitPoints, final int movement, final Location position,
                        final IEquipableItem... items);

    IUnit createUnit();
}
