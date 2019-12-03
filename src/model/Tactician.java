package model;

import model.units.IUnit;

import java.util.List;

public class Tactician {
    private String name;
    private List<IUnit> units;
    private IUnit selectedUnit;

    /**
     * Sets tactician's name and units
     */
    public Tactician(String name, List<IUnit> units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return this.name;
    }

    public List<IUnit> getUnits(){ return List.copyOf(units);}


    public void selectUnit(IUnit unit){
        this.selectedUnit = unit;

    }

    public IUnit getSelectedUnit() {

        return this.selectedUnit;
    }
}
