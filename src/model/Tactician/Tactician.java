package model.Tactician;

import model.units.IUnit;

public class Tactician {
    private String name;
    private IUnit units;


    public void tactician(String name){

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public IUnit getSelectedUnit() {
        return this.units;
    }
}
