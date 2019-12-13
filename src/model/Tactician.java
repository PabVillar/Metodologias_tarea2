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
    private Field gameMap;
    private Location currentCell;

    /**
     * Creates a new tactician
     * @param name
     */
    public Tactician(String name) {
        this.name = name;
    }

    /**
     *
     * @return the name of the tactician
     */
    public String getName() {
        return name;
    }

    /**
     *
     */
    public Tactician(){
        support = new PropertyChangeSupport(this);
    }

    /**
     *
     * @param pcl
     */
    public void addPropertyChangeListener(PropertyChangeListener pcl){
        support.addPropertyChangeListener(pcl);
    }

    /**
     *
     * @param pcl
     */
    public void removePropertyChangeListener(PropertyChangeListener pcl){
        support.removePropertyChangeListener(pcl);
    }

    /**
     *
     * @param x
     *      Horizontal position of the unit
     * @param y
     *      Vertical position of the unit
     */
    public void selectUnitIn(int x, int y){
        support.firePropertyChange("cell",this.currentCell,this.gameMap.getCell(x,y));
    }

    /**
     * Sets the tactician's selected unit
     * @param newUnit
     *
     */
    public void setSelectedUnit(IUnit newUnit) {
        this.selectedUnit = newUnit;
    }

    /**
     *
     * @return the tactician's selected unit
     */
    public IUnit getSelectedUnit() {
        return this.selectedUnit;
    }


}
