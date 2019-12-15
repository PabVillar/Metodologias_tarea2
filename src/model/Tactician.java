package model;

import controller.GameController;
import controller.state.GameState;
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
    private List<IEquipableItem> items;
    private IUnit selectedUnit;
    private PropertyChangeSupport selectUnitInSupport = new PropertyChangeSupport(this),
            selectItemSupport = new PropertyChangeSupport(this),
            equipItemSupport = new PropertyChangeSupport(this),
            useItemOnSupport = new PropertyChangeSupport(this),
            giveItemToSupport = new PropertyChangeSupport(this),
            moveUnitToSupport = new PropertyChangeSupport(this),
            endTurnSupport = new PropertyChangeSupport(this);

    private Location currentCell;
    private int selectedItemIndex,
                equippedItemIndex;

    private Location selectedCell;
    private IEquipableItem selectedItem;
    private final GameController gameController = GameController.getInstance();
    private GameState state;



    /**
     * Creates a new tactician
     * @param name
     */
    public Tactician(String name) {
        this.name = name;

        selectUnitInSupport.addPropertyChangeListener(new SelectUnitInHandler(gameController));
        selectItemSupport.addPropertyChangeListener(new SelectItemHandler(gameController));
        equipItemSupport.addPropertyChangeListener(new EquipItemHandler(gameController));
        useItemOnSupport.addPropertyChangeListener(new UseItemOnHandler(gameController));
        giveItemToSupport.addPropertyChangeListener(new GiveItemToHandler(gameController));
        moveUnitToSupport.addPropertyChangeListener(new MoveUnitToHandler(gameController));



    }

     public void setState(GameState state){
        this.state = state;
        state.setTactician(this);
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
        Location cell = gameController.getGameMap().getCell(x,y);
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
     * Selects an item of the inventory
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
        Location cell = gameController.getGameMap().getCell(x,y);
        this.useItemOnSupport.firePropertyChange("useItem",this.selectedCell,cell);
        this.selectedCell = cell;
    }

    /**
     * Gives the selected item to a target
     * @param x
     *      The horizontal position of the target
     * @param y
     *      The vertical position of the target
     */
    public void giveItemTo(int x, int y){
        Location cell = gameController.getGameMap().getCell(x,y);
        this.giveItemToSupport.firePropertyChange("giveItem",this.selectedCell,cell);
        this.selectedCell = cell;
    }

    /**
     * Moves the selected unit to the target position
     * @param x
     * @param y
     */
    public void moveUnitTo(int x, int y){
        Location position = gameController.getGameMap().getCell(x,y);
        this.moveUnitToSupport.firePropertyChange("moveTo",this.currentCell,position);
        this.currentCell = position;
    }


    /**
     * Selects an item of the inventory
     * @param item
     */
    public void setSelectedItem(IEquipableItem item) {
        this.selectedItem = item;
    }

    /**
     *
     * @return the selected item of the inventory
     */
    public IEquipableItem getSelectedItem(){
        return this.selectedItem;
    }

    /**
     * Sets the list of units for the tactician
     * @param units
     */
    public void setUnits(List<IUnit> units) {
        this.units = units;
    }

    /**
     * The tactician can realize different movements during their turn
     */
    public void playTurn() {

    }

    /**
     * The tactician can choose end their turn
     * The turn ends automatically if their hero is defeated
     */
    public void endTurn(){

    }

    /**
     *
     * @return the list of the tactician's units
     */
    public List<IUnit> getUnits() {
        return this.units;
    }


    /**
     * Sets the list of items for the units
     * @param items
     *         The items to be set
     */
    public void setItems(List<IEquipableItem> items) {
        this.items = items;
    }


    /**
     * Adds an item to the inventory
     * @param item
     */
    public void addToInventory(IEquipableItem item){
        this.getSelectedUnit().addItems(item);
    }

    /**
     *
     * @return the list of the items for the units
     */
    public List<IEquipableItem> getItems(){ return this.items;}
}
