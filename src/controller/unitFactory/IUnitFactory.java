package controller.unitFactory;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.IUnit;

public interface IUnitFactory {

    /**
     *
     * @param hitPoints
     * @param movement
     * @param position
     * @param items
     * @return a new unit
     */
    IUnit create(final int hitPoints, final int movement, final Location position,
                        final IEquipableItem... items);

    IUnit createUnit();
}
