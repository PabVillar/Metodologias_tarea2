package controller.itemFactory;

import model.items.AenimaMagicBook;

public class AenimaMagicBookFactory extends ItemFactory {

    @Override
    public AenimaMagicBook create(final String name, final int power, final int minRange, final int maxRange){
        return new AenimaMagicBook(name, power, minRange, maxRange);
    }
}
