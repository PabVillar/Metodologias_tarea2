package controller.itemFactory;

import model.items.IEquipableItem;

public interface IEquipableItemFactory {

    IEquipableItem create(final String name, final int power, final int minRange, final int maxRange);

    IEquipableItem createItem();
}
