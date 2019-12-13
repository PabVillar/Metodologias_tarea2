package controller.unitFactory;

import model.map.Location;
import model.units.IUnit;
import model.units.NullUnit;

import java.util.HashMap;

import static java.lang.Math.min;

public abstract class UnitFactory implements IUnitFactory {

    private static final HashMap<IUnitFactory, IUnit> unitMap = new HashMap<IUnitFactory,IUnit>();
    private int hitPoints = 50;
    private int movement = 2;
    private Location location;
    private IUnitFactory type;

    public void setHitPoints(int hitPoints){
        this.hitPoints = hitPoints;
    }

    public void setMovement(int movement){
        this.movement = movement;
    }

    public void setLocation(Location location){
        this.location = location;
    }


    public void setType(IUnitFactory type){
        this.type = type;
    }

    @Override
    public IUnit createUnit(){
        return this.type.create(this.hitPoints,this.movement,this.location);
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
