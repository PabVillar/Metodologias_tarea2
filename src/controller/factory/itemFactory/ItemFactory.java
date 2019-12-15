package controller.factory.itemFactory;

import model.items.IEquipableItem;

import java.util.HashMap;

public class ItemFactory implements IEquipableItemFactory {
    private String name;
    private int power = 10;
    private int minRange = 1;
    private int maxRange = 2;
    private static final HashMap<IEquipableItemFactory,IEquipableItem> itemMap = new HashMap<IEquipableItemFactory,IEquipableItem>();
    private  IEquipableItemFactory type;

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

    public void setType(IEquipableItemFactory type){ this.type = type; }

    @Override
    public IEquipableItem create(String name, int power, int minRange, int maxRange) {
        return type.create(name,power,minRange,maxRange);
    }

    @Override
    public IEquipableItem createItem(){
        return this.create(this.getName(),this.getPower(),this.getMinRange(),this.getMaxRange());
    }

    public static IEquipableItem getItem(IEquipableItemFactory type){
        IEquipableItem item;
        if (itemMap.containsKey(type)){
            item = itemMap.get(type);
        }
        else {
            item = type.createItem();
            itemMap.put(type,item);
        }

        return item;
    }


    public String getName(){ return this.name; }

    public int getPower(){ return this.power; }

    public int getMinRange(){return this.minRange;}

    public int getMaxRange(){return this.maxRange;}

    public IEquipableItemFactory getType(){return this.type;}
}
