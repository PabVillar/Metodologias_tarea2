package controller.factory.itemFactory;

import model.items.Bow;

public class BowFactory extends ItemFactory {
    @Override
    public Bow create(String name, int power, int minRange, int maxRange) {
        return new Bow(name,power,minRange,maxRange);
    }
}
