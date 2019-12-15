package controller.factory.itemFactory;

import model.items.IEquipableItem;

public interface IEquipableItemFactory {

    /**
     * Creates a new item
     * @param name
     * @param power
     * @param minRange
     * @param maxRange
     * @return the new item
     */
    IEquipableItem create(final String name, final int power, final int minRange, final int maxRange);

    IEquipableItem createItem();
}
