package controller;

import model.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Ignacio Slater Muñoz
 * @version 2.0
 * @since 2.0
 */
public class GameController {

  private List<Tactician> tacticians;
  private Tactician currentTactician;
  private Field map;



  /**
   * Creates the controller for a new game.
   *
   * @param numberOfPlayers
   *     the number of players for this game
   * @param mapSize
   *     the dimensions of the map, for simplicity, all maps are squares
   */
  public GameController(int numberOfPlayers, int mapSize) {

  }

  /**
   * @return the list of all the tacticians participating in the game.
   */
  public List<Tactician> getTacticians() {
    return tacticians;
  }

  /**
   * @return the map of the current game
   */
  public Field getGameMap() {
    return map;
  }

  /**
   * @return the tactician that's currently playing
   */
  public Tactician getTurnOwner() {
    return currentTactician;
  }

  /**
   * @return the number of rounds since the start of the game.
   */
  public int getRoundNumber() {
    return 0;
  }

  /**
   * @return the maximum number of rounds a match can last
   */
  public int getMaxRounds() {
    return 0;
  }

  /**
   * Finishes the current player's turn.
   */
  public void endTurn() {

  }

  /**
   * Removes a tactician and all of it's units from the game.
   *
   * @param tactician
   *     the player to be removed
   */
  public void removeTactician(String tactician) {

  }

  /**
   * Starts the game.
   * @param maxTurns
   *  the maximum number of turns the game can last
   */
  public void initGame(final int maxTurns) {

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

    return getTurnOwner().getSelectedUnit();
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

  }

  /**
   * @return the inventory of the currently selected unit.
   */
  public List<IEquipableItem> getItems() {

    return getSelectedUnit().getItems();
  }

  /**
   * Equips an item from the inventory to the currently selected unit.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void equipItem(int index) {
    IEquipableItem item = getSelectedUnit().getItems().get(index);
    currentTactician.getSelectedUnit().setEquippedItem(item);
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

  }

  /**
   * Selects an item from the selected unit's inventory.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void selectItem(int index) {

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
    IUnit receiver = map.getCell(x,y).getUnit();
    IEquipableItem item = getSelectedItem();
    currentTactician.getSelectedUnit().giveItemTo(receiver,item);

  }


  public IEquipableItem getSelectedItem() {

    return currentTactician.getSelectedItem();
  }


}
