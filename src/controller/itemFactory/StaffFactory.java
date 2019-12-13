package controller.itemFactory;

import model.items.IEquipableItem;
import model.items.Staff;

public class StaffFactory extends ItemFactory {
    @Override
    public Staff create(String name, int power, int minRange, int maxRange) {
        return new Staff(name,power,minRange,maxRange);
    }
}
