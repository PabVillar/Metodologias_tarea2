package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import controller.itemFactory.IEquipableItemFactory;
import controller.itemFactory.SwordFactory;
import controller.tacticianFactory.TacticianFactory;
import controller.unitFactory.*;
import model.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.Alpaca;
import model.units.IUnit;

import static controller.tacticianFactory.TacticianFactory.getName;
import static controller.tacticianFactory.TacticianFactory.getTactician;

/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Ignacio Slater Muñoz
 * @version 2.0
 * @since 2.0
 */
public class GameController {
  private final Field gameMap = new Field();
  private List<Tactician> tacticians = new ArrayList<>();
  private Tactician currentTactician;
  private int roundNumber;
  private int maxRounds;


  private GameController(){}


  private static class SingletonGameControllerHolder{
    static final GameController SINGLE_INSTANCE = new GameController();
  }

  /**
   *
   * @return the single instance of the game controller
   */
  public static GameController getInstance(){
    return SingletonGameControllerHolder.SINGLE_INSTANCE;
  }
  /**
   * Creates the controller for a new game.
   *
   * @param numberOfPlayers
   *     the number of players for this game
   * @param mapSize
   *     the dimensions of the map, for simplicity, all maps are squares
   */
  public GameController(int numberOfPlayers, int mapSize) {
    TacticianFactory tacticianFactory = new TacticianFactory();
    for(int i = 0; i<numberOfPlayers; i++){
      tacticianFactory.setName(i);
      Tactician tactician = getTactician(getName());
      tacticians.add(tactician);
    }
    List<Location> cells = new ArrayList<>();
    for (int i = 0; i<mapSize;i++){
      for (int j = 0; j < mapSize; j++){
        cells.add(new Location(i,j));
        this.gameMap.addCells(false,cells.get(i));
      }
    }

  }

  /**
   * @return the list of all the tacticians participating in the game.
   */
  public List<Tactician> getTacticians() {
    return List.copyOf(tacticians);
  }

  /**
   * @return the map of the current game
   */
  public Field getGameMap() {
    return this.gameMap;
  }

  /**
   * Sets the inicial state of the game
   * The tacticians get a Hero and can select the other units
   */
  public void setGame(){
    UnitFactory unitFactory = new UnitFactory();
    for (int i = 0; i < getTacticians().size(); i++){
      setCurrentTactician(this.tacticians.get(i));
      this.currentTactician.setUnits(createUnits());
    }
  }

  private List<IUnit> createUnits() {
    List<IUnit> units = new ArrayList<>();
    IUnit alpaca = UnitFactory.getUnit(new AlpacaFactory()),
            archer = UnitFactory.getUnit(new ArcherFactory()),
            cleric = UnitFactory.getUnit(new ClericFactory()),
            fighter = UnitFactory.getUnit(new FighterFactory()),
            hero = UnitFactory.getUnit(new HeroFactory()),
            sorcerer = UnitFactory.getUnit(new SorcererFactory()),
            swordMaster = UnitFactory.getUnit(new SwordMasterFactory());
    units.add(alpaca);
    units.add(archer);
    units.add(cleric);
    units.add(fighter);
    units.add(hero);
    units.add(sorcerer);
    units.add(swordMaster);
    return units;
  }

  private void setCurrentTactician(Tactician tactician) {

    this.currentTactician = tactician;
  }

  private void setRoundNumber(int round) {
    this.roundNumber = round;
  }

  /**
   * @return the tactician that's currently playing
   */
  public Tactician getTurnOwner() {
    return this.currentTactician;
  }

  /**
   * @return the number of rounds since the start of the game.
   */
  public int getRoundNumber() {
    return this.roundNumber;
  }

  /**
   * @return the maximum number of rounds a match can last
   */
  public int getMaxRounds() {
    return this.maxRounds;
  }

  /**
   * Finishes the current player's turn.
   */
  public void endTurn() {
    //Se implementa con observer. El jugador puede decidir cuando terminar su turno
    //Tambien se termina el turno despues de que el jugador haya movido una vez a cada una de sus unidades
    int index = this.tacticians.indexOf(this.currentTactician);
    Tactician nextTactician = this.tacticians.get(index+1);

  }

  /**
   * Removes a tactician and all of it's units from the game.
   *
   * @param tactician
   *     the player to be removed
   */
  public void removeTactician(String tactician) {
    // El tactician se retira con sus unidades si es que su Hero es derrotado
    for (int i=0;i < tacticians.size();i++){
      String name = tacticians.get(i).getName();
      if (name.equals(tactician)){
        tacticians.remove(i);
      }
    }
    }


  /**
   * Starts the game.
   * @param maxTurns
   *  the maximum number of turns the game can last
   */
  public void initGame(final int maxTurns) {

    int round = 1;


    //El juego dura mientras no se haya alcanzado la cantidad maxima de rondas
    //y mientras queden al menos dos jugadores en el campo

    while (this.tacticians.size() > 1 && getRoundNumber() < getMaxRounds()) {
      setRoundNumber(round);
      setCurrentTactician(this.tacticians.get(0));
      Tactician nextPlayer = this.tacticians.get(1);

      if (nextPlayer.getName().equals(getTurnOwner().getName())) {
        Collections.shuffle(this.tacticians);
      } else {
        for (int i = 0; i < getTacticians().size(); i++) {
          this.currentTactician = this.getTacticians().get(i);
          //playTurn();
          endTurn();
        }
      }

      round++;
      Collections.shuffle(this.tacticians);


    }
  }



  private void playTurn() {
  }


  /**
   * Starts a game without a limit of turns.
   */
  public void initEndlessGame() {

  }

  /**
   * @return the winner of this game, if the match ends in a draw returns a list of all the winners
   */
  public List<String> getWinners() {
    return null;
  }

  /**
   * @return the current player's selected unit
   */
  public IUnit getSelectedUnit() {
    return currentTactician.getSelectedUnit();
  }

  /**
   * Communicates to the controller when the current tactician wants to change the state of the game
   * @param evt
   */


  /**
   * Selects a unit in the game map
   *
   * @param x
   *     horizontal position of the unit
   * @param y
   *     vertical position of the unit
   */
  public void selectUnitIn(int x, int y) {
        Location cell = this.getGameMap().getCell(x,y);
        this.currentTactician.setSelectedUnit(cell.getUnit());
  }

  /**
   * @return the inventory of the currently selected unit.
   */
  public List<IEquipableItem> getItems() {
    return this.getSelectedUnit().getItems();
  }

  /**
   * Equips an item from the inventory to the currently selected unit.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void equipItem(int index) {
    IEquipableItem item = this.getSelectedUnit().getItems().get(index);
    this.currentTactician.getSelectedUnit().equipItem(item);
  }

  /**
   * Uses the equipped item on a target
   *
   * @param x
   *     horizontal position of the target
   * @param y
   *     vertical position of the target
   */
  public void useItemOn(int x, int y) {
    Location targetCell = getGameMap().getCell(x,y);
    IUnit unit = targetCell.getUnit();
    this.currentTactician.getSelectedUnit().attack(unit);
  }

  /**
   * Selects an item from the selected unit's inventory.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void selectItem(int index) {
    IEquipableItem item = this.currentTactician.getSelectedUnit().getItems().get(index);
    this.currentTactician.setSelectedItem(item);
  }

  /**
   * Gives the selected item to a target unit.
   *
   * @param x
   *     horizontal position of the target
   * @param y
   *     vertical position of the target
   */
  public void giveItemTo(int x, int y) {
    Location targetCell = getGameMap().getCell(x,y);
    IUnit unit = targetCell.getUnit();
    this.currentTactician.getSelectedUnit().giveItemTo(unit,this.currentTactician.getSelectedItem());
  }


}
