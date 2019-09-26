package model.items;

/**
 * @author Pablo Villar Mascaro
 *
 *
 */
public abstract class MagicBook extends AbstractItem implements IMagicBook {

    /**
     * Creates a new magic book.
     * <p>
     *  @param name
     *     the name of the book
     * @param power
     *     the damage power of the book
 * @param minRange
     *     the minimum range of the book
 * @param maxRange   
     */


    public MagicBook(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public int versusSword() {
        return 1;
    }

    @Override
    public int versusAxe() {
        return 1;
    }

    @Override
    public int versusBow() {
        return 1;
    }

    @Override
    public int versusSpear() {
        return 1;
    }

    @Override
    public int versusStaff() {
        return 1;
    }

}

