package controller.factory.unitFactory;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.IUnit;
import model.units.NullUnit;

import java.util.HashMap;

import static java.lang.Math.min;

public class UnitFactory implements IUnitFactory {

    private static final HashMap<IUnitFactory, IUnit> unitMap = new HashMap<IUnitFactory,IUnit>();
    private int hitPoints = 50;
    private int movement = 2;
    private Location location;
    private IUnitFactory type;

    /**
     * Sets the hitpoints of the new unit
     * @param hitPoints
     */
    public void setHitPoints(int hitPoints){
        this.hitPoints = hitPoints;
    }

    /**
     * Sets the movement of the new unit
     * @param movement
     */
    public void setMovement(int movement){
        this.movement = movement;
    }

    /**
     * Sets the location of the new unit
     * @param location
     */
    public void setLocation(Location location){
        this.location = location;
    }


    /**
     * Sets the type of the unit
     * @param type
     */
    public void setType(IUnitFactory type){
        this.type = type;
    }

    /**
     *
     * @return the HP of the created unit
     */
    public int getHitPoints(){ return this.hitPoints; }

    /**
     *
     * @return the movement of the created unit
     */
    public int getMovement(){ return this.movement; }


    /**
     *
     * @return the location of the created unit
     */
    public Location getLocation(){ return this.location; }



    @Override
    public IUnit create(int hitPoints, int movement, Location position, IEquipableItem... items) {
        return type.create(hitPoints,movement,position);
    }

    @Override
    public IUnit createUnit(){
        return this.create(this.getHitPoints(),this.getMovement(),this.getLocation());
    }


    /**
     *
     * @param type
     * @return a new unit for the tactician
     */
    public static IUnit getUnit(IUnitFactory type){
        IUnit unit = new NullUnit();

        if (unitMap.containsKey(type)){
            unit = unitMap.get(type);
        }
        else {
            unit = type.createUnit();
            unitMap.put(type,unit);
        }
        return unit;
    }





}
