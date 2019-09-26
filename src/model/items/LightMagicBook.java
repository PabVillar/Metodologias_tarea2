package model.items;

public class LightMagicBook extends MagicBook {


    /**
     * Creates a new light magic book
     *
     * @param name
     *
     * @param power
     *
     * @param minRange
     *
     * @param maxRange
     */
    public LightMagicBook(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }


    @Override
    public int versusLightMagicBook() {
        return 0;
    }

    @Override
    public int versusDarkMagicBook() {
        return -1;
    }

    @Override
    public int versusAenimaMagicBook() {
        return 1;
    }

    @Override
    public int versus(IEquipableItem item) {
        return item.versusLightMagicBook();
    }
}
