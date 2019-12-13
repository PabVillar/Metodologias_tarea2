package controller.itemFactory;

import model.items.IEquipableItem;
import model.items.Sword;

public class SwordFactory extends ItemFactory {
    @Override
    public Sword create(String name, int power, int minRange, int maxRange) {
        return new Sword(name,power,minRange,maxRange);
    }
}
