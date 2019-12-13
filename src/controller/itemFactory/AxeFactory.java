package controller.itemFactory;

import model.items.Axe;
import model.items.IEquipableItem;

public class AxeFactory extends ItemFactory {
    @Override
    public Axe create(String name, int power, int minRange, int maxRange) {
        return new Axe(name,power,minRange,maxRange);
    }
}
