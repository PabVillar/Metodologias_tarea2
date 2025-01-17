package model.items;

public class DarkMagicBook extends MagicBook {
    /**
     * Creates a new magic book.
     * <p>
     *
     * @param name     the name of the book
     * @param power    the damage power of the book
     * @param minRange the minimum range of the book
     * @param maxRange
     */
    public DarkMagicBook(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public int versus(IEquipableItem item) {
        return item.versusDarkMagicBook();
    }

    @Override
    public int versusAenimaMagicBook(){return 1;}

    @Override
    public int versusLightMagicBook(){return -1;}

    @Override
    public int versusDarkMagicBook(){return 0;}

    @Override
    public int versusAxe(){return 1;}

    @Override
    public int versusBow(){return 1;}

    @Override
    public int versusSpear(){return 1;}

    @Override
    public int versusSword(){return 1;}
}
