package model.items;

public class AenimaMagicBook extends MagicBook {
    /**
     * Creates a new magic book.
     * <p>
     *
     * @param name     the name of the book
     * @param power    the damage power of the book
     * @param minRange the minimum range of the book
     * @param maxRange
     */
    public AenimaMagicBook(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public int versus(IEquipableItem item) {
        return item.versusAenimaMagicBook();
    }

    @Override
    public int versusAenimaMagicBook(){return 0;}

    @Override
    public int versusLightMagicBook(){return 1;}

    @Override
    public int versusDarkMagicBook(){return -1;}

    @Override
    public int versusAxe(){return 1;}

    @Override
    public int versusBow(){return 1;}

    @Override
    public int versusSpear(){return 1;}

    @Override
    public int versusSword(){return 1;}
}
