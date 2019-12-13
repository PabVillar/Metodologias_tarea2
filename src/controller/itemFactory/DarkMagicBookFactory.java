package controller.itemFactory;

import model.items.DarkMagicBook;
import model.items.IEquipableItem;

public class DarkMagicBookFactory extends ItemFactory {

    @Override
    public DarkMagicBook create(String name, int power, int minRange, int maxRange) {
        return new DarkMagicBook(name,power,minRange,maxRange);
    }
}
