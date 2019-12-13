package model;

import model.map.Field;
import model.map.Location;
import model.units.IUnit;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Tactician {
    private String name;
    private IUnit selectedUnit;
    private PropertyChangeSupport support;
    private Field map;

    public Tactician(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Tactician(){
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl){
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl){
        support.removePropertyChangeListener(pcl);
    }

    public void selectUnitIn(int x, int y){
        support.firePropertyChange("cell",this.currentCell,);
        Location cell = this.map.getCell(x,y);
        support.firePropertyChange("Selected unit",this.selectedUnit,cell.getUnit());
        setSelectedUnit(cell.getUnit());

    }

    public void setSelectedUnit(IUnit newValue) {
        this.selectedUnit = newValue;
    }

    public IUnit getSelectedUnit() {
        return this.selectedUnit;
    }


}
