package controller.itemFactory;

import model.items.Bow;
import model.items.IEquipableItem;

public class BowFactory extends ItemFactory {
    @Override
    public Bow create(String name, int power, int minRange, int maxRange) {
        return new Bow(name,power,minRange,maxRange);
    }
}
