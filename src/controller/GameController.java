package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import controller.factory.itemFactory.*;
import controller.factory.tacticianFactory.TacticianFactory;
import controller.factory.unitFactory.*;
import controller.state.GameState;
import model.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.IUnit;

import static controller.factory.tacticianFactory.TacticianFactory.getName;
import static controller.factory.tacticianFactory.TacticianFactory.getTactician;

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
  private List<String> winners = new ArrayList<>();


  private GameController(){}


  private static class SingletonGameControllerHolder{
    private static GameController SINGLE_INSTANCE;
    private static int numberOfPlayers;
    private static int mapSize;

    /**
     * set the number of players in the game
     * @param players
     */
    public static void setNumberOfPlayers(final int players){ numberOfPlayers = players; }

    /**
     * set the size of the map
     * @param size
     */
    public  static void setMapSize(final int size){ mapSize = size;}

    /**
     *
     * @return the number of players in the game
     */
    public int getNumberOfPlayers(){return numberOfPlayers;}

    /**
     *
     * @return the size of the map
     */
    public int getMapSize(){return mapSize;}

    /**
     * sets the single instance of the controller
     */
    public void setSingleInstance(){SINGLE_INSTANCE = new GameController(numberOfPlayers,mapSize);}

    /**
     *
     * @return the single instance of the controller
     */
    public static GameController getInstance(){ return SINGLE_INSTANCE;}
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
    SingletonGameControllerHolder.setNumberOfPlayers(numberOfPlayers);
    SingletonGameControllerHolder.setMapSize(mapSize);
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
    setGame();
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
   * The tacticians get all the units
   */
  public void setGame(){
    UnitFactory unitFactory = new UnitFactory();
    for (int i = 0; i < getTacticians().size(); i++){
      setCurrentTactician(this.tacticians.get(i));
      this.currentTactician.setUnits(createUnits());
      this.currentTactician.setItems(createItems());
    }
  }


  /**
   * creates units for the tacticians
   * @return a list of units for each tactician
   */
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


  /**
   * creates items for the tactician's units
   * @return a list of new items
   */
  public List<IEquipableItem> createItems(){
    List<IEquipableItem> items = new ArrayList<>();
    IEquipableItem aenimaMagicBook = ItemFactory.getItem(new AenimaMagicBookFactory()),
            axe = ItemFactory.getItem(new AxeFactory()),
            bow = ItemFactory.getItem(new BowFactory()),
            darkMagicBook = ItemFactory.getItem(new DarkMagicBookFactory()),
            lightMagicBook = ItemFactory.getItem(new LightMagicBookFactory()),
            spear = ItemFactory.getItem(new SpearFactory()),
            staff = ItemFactory.getItem(new StaffFactory()),
            sword = ItemFactory.getItem(new SwordFactory());
    items.add(aenimaMagicBook);
    items.add(axe);
    items.add(bow);
    items.add(darkMagicBook);
    items.add(lightMagicBook);
    items.add(spear);
    items.add(staff);
    items.add(sword);
    return items;

  }

  /**
   * Sets the tactician who has the turn in the game
   * @param tactician
   */
  public void setCurrentTactician(Tactician tactician) {
    this.currentTactician = tactician;
  }



  /**
   * Sets the current number of rounds in the game
   * @param round
   */
  public void setRoundNumber(int round) {
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
    Tactician nextTactician;
    if(index<this.tacticians.size()-1){
      nextTactician = this.tacticians.get(index+1);
      setCurrentTactician(nextTactician);
    }
    else{
      setCurrentTactician(this.tacticians.get(0));
    }

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
   * Removes a defeated unit
   * @param unit
   *        The defeated unit to remove
   */
  public void removeDefeatedUnit(IUnit unit){
    int index = currentTactician.getUnits().indexOf(unit);
    currentTactician.getUnits().remove(index);
  }

  /**
   * Starts the game.
   * @param maxTurns
   *  the maximum number of turns the game can last
   */
  public void initGame(final int maxTurns) {
    int round = 1;
    setMaxRounds(maxTurns);
    setRoundNumber(round);
    int i = 0;
    int initialSize = this.tacticians.size();

    while (getRoundNumber() < getMaxRounds() && tacticians.size()>1){
      while(i < tacticians.size()){
        currentTactician = tacticians.get(i);
        currentTactician.playTurn();
        endTurn();
        i++;
      }
      round++;
      setRoundNumber(round);
      Collections.shuffle(tacticians);

    }

    if(this.tacticians.size() != initialSize)
      for (int j = 0; j < tacticians.size(); j++){
        this.winners.add(tacticians.get(j).getName());
      }

  }




  /**
   * Sets the maximum number of rounds the game can last
   * @param maxTurns
   *
   */
  public void setMaxRounds(final int maxTurns) {
    this.maxRounds = maxTurns;
  }


  /**
   * Starts a game without a limit of turns.
   */
  public void initEndlessGame() {

    setMaxRounds(-1);
    int i = 0;

    while (tacticians.size()>1) {
      while (i < tacticians.size()) {
        currentTactician = tacticians.get(i);
        currentTactician.playTurn();
        endTurn();
        i++;
      }
    }
    this.winners.add(currentTactician.getName());
  }

  /**
   *
   * @return the winner of this game, if the match ends in a draw returns a list of all the winners
   */
  public List<String> getWinners() {

    return this.winners;
  }

  /**
   * @return the current player's selected unit
   */
  public IUnit getSelectedUnit() {
    return currentTactician.getSelectedUnit();
  }



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
    return this.currentTactician.getItems();
  }

  /**
   * Equips an item from the inventory to the currently selected unit.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void equipItem(int index) {
    IEquipableItem item = this.currentTactician.getSelectedUnit().getItems().get(index);
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

  /**
   * Moves the selected unit to a target location
   * @param x
   *      horizontal position of the cell
   * @param y
   *      vertical position of the cell
   */
  public void moveUnitTo(int x, int y){
    Location targetCell = getGameMap().getCell(x,y);
    this.currentTactician.getSelectedUnit().moveTo(targetCell);
  }


}
