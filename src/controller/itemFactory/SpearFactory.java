package controller.itemFactory;

import model.items.IEquipableItem;
import model.items.Spear;

public class SpearFactory extends ItemFactory {
    @Override
    public Spear create(String name, int power, int minRange, int maxRange) {
        return new Spear(name,power,minRange,maxRange);
    }
}
