package controller.factory.itemFactory;

import model.items.LightMagicBook;

public class LightMagicBookFactory extends ItemFactory {
    @Override
    public LightMagicBook create(String name, int power, int minRange, int maxRange) {
        return new LightMagicBook(name,power,minRange,maxRange);
    }
}
