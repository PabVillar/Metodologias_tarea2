package model;

import model.items.IEquipableItem;
import model.map.Location;
import model.units.IUnit;

import java.util.List;

public class Tactician {
    private String name;
    private List<IUnit> units;
    private IUnit selectedUnit;

    /**
     * Sets tactician's name and units
     */
    public Tactician(String name) {
        this.name = name;
    }

    public void setUnits(List<IUnit> units) {
        this.units = units;
    }

    public String getName() {
        return this.name;
    }

    public List<IUnit> getUnits(){ return List.copyOf(units);}


    public void selectUnit(IUnit unit){
        if (getUnits().contains(unit)){
            this.selectedUnit = unit;
        }

    }

    public IUnit getSelectedUnit() {
        return this.selectedUnit;
    }

    public void selectItem(IEquipableItem item){

    }

    public IEquipableItem getSelectedItem() {
        return null;
    }
}
