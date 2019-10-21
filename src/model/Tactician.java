package model;

import model.units.IUnit;

import java.util.List;

public class Tactician {
    private String name;
    private List<IUnit> units;

    public Tactician(String name) {
        this.name = name;
    }

    public Tactician(List<IUnit> units){
        this.units = units;
    }

    public String getName() {
        return this.name;
    }

    public List<IUnit> getUnits(){ return List.copyOf(units);}







}
