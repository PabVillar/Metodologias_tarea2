package controller.itemFactory;

import model.items.IEquipableItem;
import model.items.NullItem;

import java.util.HashMap;

public abstract class ItemFactory implements IEquipableItemFactory {
    private String name;
    private int power = 10;
    private int minRange = 1;
    private int maxRange = 2;
    private static final HashMap<IEquipableItemFactory,IEquipableItem> itemMap = new HashMap<IEquipableItemFactory,IEquipableItem>();
    private IEquipableItemFactory type;

    public void setName(String name){
        this.name = name;
    }

    public void setPower(int power){
        this.power = power;
    }

    public void setMinRange(int minRange){
        this.minRange = minRange;
    }

    public void setMaxRange(int maxRange){
        this.maxRange = maxRange;
    }

    @Override
    public IEquipableItem createItem(){
        return type.create(this.name,this.power,this.minRange,this.maxRange);
    }

    public static IEquipableItem getItem(IEquipableItemFactory type){
        IEquipableItem item = new NullItem();
        if (itemMap.containsKey(type)){
            item = itemMap.get(type);
        }
        else {
            item = type.createItem();
            itemMap.put(type,item);
        }

        return item;
    }





}
