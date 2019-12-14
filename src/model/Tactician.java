package model;

import controller.GameController;
import model.handlers.*;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Tactician {
    private String name;
    private List<IUnit> units = new ArrayList<>();
    private IUnit selectedUnit;
    private PropertyChangeSupport selectUnitInSupport = new PropertyChangeSupport(this),
            selectItemSupport = new PropertyChangeSupport(this),
            equipItemSupport = new PropertyChangeSupport(this),
            useItemOnSupport = new PropertyChangeSupport(this),
            giveItemToSupport = new PropertyChangeSupport(this);


    private Field gameMap;
    private Location currentCell;
    private int selectedItemIndex;
    private int equippedItemIndex;
    private Location selectedCell;
    private IEquipableItem selectedItem;



    /**
     * Creates a new tactician
     * @param name
     */
    public Tactician(String name) {
        this.name = name;
        final GameController gameController = GameController.getInstance();

        selectUnitInSupport.addPropertyChangeListener(new selecUnitInHandler(gameController));
        selectItemSupport.addPropertyChangeListener(new selectItemHandler(gameController));
        equipItemSupport.addPropertyChangeListener(new equipItemHandler(gameController));
        useItemOnSupport.addPropertyChangeListener(new useItemOnHandler(gameController));
        giveItemToSupport.addPropertyChangeListener(new giveItemToHandler(gameController));

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
     * @param x
     *      Horizontal position of the unit
     * @param y
     *      Vertical position of the unit
     */
    public void selectUnitIn(int x, int y){
        Location cell = gameMap.getCell(x,y);
        this.selectUnitInSupport.firePropertyChange("selectUnitIn",this.currentCell,cell);
        this.currentCell = cell;

    }

    /**
     * Sets the tactician's selected unit
     * @param unit
     *
     */
    public void setSelectedUnit(IUnit unit) {
        this.selectedUnit = unit;
    }

    /**
     *
     * @return the tactician's selected unit
     */
    public IUnit getSelectedUnit() {
        return this.selectedUnit;
    }

    /**
     *
     * @param index
     */
    public void selectItem(int index){
        this.selectItemSupport.firePropertyChange("selectItem",this.selectedItemIndex,index);
        this.selectedItemIndex = index;
    }

    /**
     *
     * @param index
     *         The location of the item in the inventory
     */
    public void equipItem(int index){
        this.equipItemSupport.firePropertyChange("equipItem",this.equippedItemIndex,index);
        this.equippedItemIndex = index;
    }

    /**
     * Uses the equipped item on a target
     * @param x
     *      The horizontal position of the target
     * @param y
     *      The vertical position of the target
     */
    public void useItemOn(int x, int y){
        Location cell = gameMap.getCell(x,y);
        this.useItemOnSupport.firePropertyChange("useItem",this.selectedCell,cell);
        this.selectedCell = cell;
    }

    public void giveItemTo(int x, int y){
        Location cell = gameMap.getCell(x,y);
        this.giveItemToSupport.firePropertyChange("giveItem",this.selectedCell,cell);
        this.selectedCell = cell;
    }


    public void setSelectedItem(IEquipableItem item) {
        this.selectedItem = item;
    }

    public IEquipableItem getSelectedItem(){
        return this.selectedItem;
    }

    public void setUnits(List<IUnit> units) {
        this.units = units;
    }
}
