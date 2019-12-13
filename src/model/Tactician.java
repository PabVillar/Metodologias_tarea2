package model;

import model.units.IUnit;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Tactician {
    private String name;
    private IUnit selectedUnit;
    private PropertyChangeSupport support;

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

    public void selecUnitIn(int x, int y){

    }



}
