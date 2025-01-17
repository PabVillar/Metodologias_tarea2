package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import model.Tactician;
import model.items.Bow;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.Alpaca;
import model.units.IUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 * @since v2.0
 */
class GameControllerTest {

  private GameController controller;
  private long randomSeed;
  private List<String> testTacticians;

  @BeforeEach
  void setUp() {
    // Se define la semilla como un número aleatorio para generar variedad en los tests
    randomSeed = new Random().nextLong();
    controller = new GameController(4, 7);
    testTacticians = List.of("Player 0", "Player 1", "Player 2", "Player 3");
  }

  @Test
  void getTacticians() {
    List<Tactician> tacticians = controller.getTacticians();
    assertEquals(4, tacticians.size());
    for (int i = 0; i < tacticians.size(); i++) {
      assertEquals("Player " + i, tacticians.get(i).getName());
    }
  }

  @Test
  void getGameMap() {
    Field gameMap = controller.getGameMap();
    assertEquals(7, gameMap.getSize()); // getSize deben definirlo
    assertTrue(controller.getGameMap().isConnected());
    Random testRandom = new Random(randomSeed);

    Field newGameMap = new Field();
    newGameMap.setRandom(testRandom);

    int mapSize = gameMap.getSize();
    List<Location> cells = new ArrayList<>();
    for (int i = 0; i<mapSize;i++){
      for (int j = 0; j < mapSize; j++){
        cells.add(new Location(i,j));
        newGameMap.addCells(false,cells.get(i));
      }
    }

    assertNotEquals(gameMap,newGameMap);

    // Para testear funcionalidades que dependen de valores aleatorios se hacen 2 cosas:
    //  - Comprobar las invariantes de las estructuras que se crean (en este caso que el mapa tenga
    //    las dimensiones definidas y que sea conexo.
    //  - Setear una semilla para el generador de números aleatorios. Hacer esto hace que la
    //    secuencia de números generada sea siempre la misma, así pueden predecir los
    //    resultados que van a obtener.
    //    Hay 2 formas de hacer esto en Java, le pueden pasar el seed al constructor de Random, o
    //    usar el método setSeed de Random.
    //  ESTO ÚLTIMO NO ESTÁ IMPLEMENTADO EN EL MAPA, ASÍ QUE DEBEN AGREGARLO (!)
  }

  @Test
  void getTurnOwner() {
    //  En este caso deben hacer lo mismo que para el mapa
    // Invariantes: que los tacticians existan y no existan dos tactician con el mismo turno
    List<Tactician> tacticians = controller.getTacticians();
    assertEquals(4,tacticians.size());
    String currentTactician = controller.getTurnOwner().getName();
    String nextTactician = controller.getTacticians().get(0).getName();
    assertNotEquals(currentTactician,nextTactician);

  }

  @Test
  void getRoundNumber() {
    controller.initGame(10);
    for (int i = 1; i < 10; i++) {
      assertEquals(i, controller.getRoundNumber());
      for (int j = 0; j < 4; j++) {
        controller.endTurn();
      }
    }
  }

  @Test
  void getMaxRounds() {
    Random randomTurnSequence = new Random();
    IntStream.range(0, 50).map(i -> randomTurnSequence.nextInt() & Integer.MAX_VALUE).forEach(nextInt -> {
      controller.initGame(nextInt);
      //System.out.println(nextInt);
      assertEquals(nextInt, controller.getMaxRounds());
      //System.out.println(nextInt);
    });
    controller.initEndlessGame();
    assertEquals(-1, controller.getMaxRounds());
  }

  @Test
  void endTurn() {
    Tactician firstPlayer = controller.getTurnOwner();
    // Nuevamente, para determinar el orden de los jugadores se debe usar una semilla
    Tactician secondPlayer = controller.getTacticians().get(0); // <- Deben cambiar esto (!)
    assertNotEquals(secondPlayer.getName(), firstPlayer.getName());

    controller.endTurn();

    assertNotEquals(firstPlayer.getName(), controller.getTurnOwner().getName());
    assertEquals(secondPlayer.getName(), controller.getTurnOwner().getName());
  }

  @Test
  void removeTactician() {
    assertEquals(4, controller.getTacticians().size());
    controller.getTacticians()
            .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

    controller.removeTactician("Player 0");
    assertEquals(3, controller.getTacticians().size());
    controller.getTacticians().forEach(tactician -> assertNotEquals("Player 0", tactician));
    controller.getTacticians()
            .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

    controller.removeTactician("Player 5");
    assertEquals(3, controller.getTacticians().size());
    controller.getTacticians()
            .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));
  }

  @Test
  void getWinners() {
    controller.initGame(2);
    IntStream.range(0, 8).forEach(i -> controller.endTurn());
    assertEquals(4, controller.getWinners().size());
    controller.getWinners()
            .forEach(player -> Assertions.assertTrue(testTacticians.contains(player)));

    controller.initGame(2);
    IntStream.range(0, 4).forEach(i -> controller.endTurn());
    assertNull(controller.getWinners());
    controller.removeTactician("Player 0");
    controller.removeTactician("Player 2");
    IntStream.range(0, 2).forEach(i -> controller.endTurn());
    List<String> winners = controller.getWinners();
    assertEquals(2, winners.size());
    assertTrue(List.of("Player 1", "Player 3").containsAll(winners));

    controller.initEndlessGame();
    for (int i = 0; i < 3; i++) {
      assertNull(controller.getWinners());
      controller.removeTactician("Player " + i);
    }
    assertTrue(List.of("Player 3").containsAll(controller.getWinners()));
  }

  // Desde aquí en adelante, los tests deben definirlos completamente ustedes
  @Test
  void getSelectedUnit() {

    controller.getTurnOwner().setSelectedUnit(controller.getTurnOwner().getUnits().get(0));
    IUnit selectedUnit = controller.getTurnOwner().getSelectedUnit();
    assertNotNull(selectedUnit);
    assertEquals(Alpaca.class,selectedUnit.getClass());
  }

  @Test
  void selectUnitIn() {

    Location position = controller.getGameMap().getCell(0,0);
    controller.getTurnOwner().getUnits().get(0).setLocation(position);
    controller.getTurnOwner().selectUnitIn(0,0);
    assertEquals(Alpaca.class,controller.getTurnOwner().getSelectedUnit());

  }

  @Test
  void getItems() {

    controller.getTurnOwner().setSelectedUnit(controller.getTurnOwner().getUnits().get(0));
    for (int i = 0; i < controller.getTurnOwner().getItems().size(); i++){
      controller.getTurnOwner().addToInventory(controller.getTurnOwner().getItems().get(i));
    }
    assertFalse(controller.getTurnOwner().getItems().isEmpty());
    assertFalse(controller.getItems().isEmpty());
    assertEquals(controller.getTurnOwner().getItems(),controller.getItems());
  }

  @Test
  void equipItem() {
    IEquipableItem item = controller.getTurnOwner().getItems().get(0);
    assertNotNull(item);
    controller.getTurnOwner().setSelectedUnit(controller.getTurnOwner().getUnits().get(0));
    for (int i = 0; i < controller.getTurnOwner().getItems().size(); i++){
      controller.getTurnOwner().addToInventory(controller.getTurnOwner().getItems().get(i));
    }
    controller.getTurnOwner().equipItem(1);
    assertEquals(item,controller.getTurnOwner().getSelectedUnit().getEquippedItem());

  }

  @Test
  void useItemOn() {
    controller.getTurnOwner().setSelectedUnit(controller.getTurnOwner().getUnits().get(5));
    for (int i = 0; i < controller.getTurnOwner().getItems().size(); i++){
      controller.getTurnOwner().addToInventory(controller.getTurnOwner().getItems().get(i));
    }
    controller.getTurnOwner().equipItem(0);

    Tactician target = controller.getTacticians().get(1);
    IUnit targetUnit = target.getUnits().get(1);
    Location targetLocation = targetUnit.getLocation();
    int x = targetLocation.getColumn();
    int y = targetLocation.getRow();

    controller.getTurnOwner().useItemOn(x,y);

    assertNotEquals(50,targetUnit.getCurrentHitPoints());


  }

  @Test
  void selectItem() {
    controller.getTurnOwner().setSelectedUnit(controller.getTurnOwner().getUnits().get(1));
    for (int i = 0; i < controller.getTurnOwner().getItems().size(); i++){
      controller.getTurnOwner().addToInventory(controller.getTurnOwner().getItems().get(i));
    }
    controller.getTurnOwner().selectItem(2);

    assertNotNull(controller.getTurnOwner().getSelectedItem());
    assertEquals(Bow.class,controller.getTurnOwner().getSelectedItem().getClass());

  }

  @Test
  void giveItemTo() {
    controller.getTurnOwner().setSelectedUnit(controller.getTurnOwner().getUnits().get(5));
    for (int i = 0; i < controller.getTurnOwner().getItems().size(); i++){
      controller.getTurnOwner().addToInventory(controller.getTurnOwner().getItems().get(i));
    }
    controller.getTurnOwner().selectItem(0);
    IEquipableItem item = controller.getTurnOwner().getSelectedItem();

    Tactician target = controller.getTacticians().get(1);
    IUnit targetUnit = target.getUnits().get(1);
    targetUnit.getItems().remove(0);
    assertFalse(targetUnit.getItems().contains(item));
    Location targetLocation = targetUnit.getLocation();
    int x = targetLocation.getColumn();
    int y = targetLocation.getRow();

    controller.getTurnOwner().giveItemTo(x,y);

    assertTrue(targetUnit.getItems().contains(item));

  }

  @Test
  void moveUnitTo(){
    controller.getTurnOwner().setSelectedUnit(controller.getTurnOwner().getUnits().get(0));
    Location actualPosition = controller.getTurnOwner().getSelectedUnit().getLocation();
    Location targetPosition = controller.getGameMap().getCell(0,1);
    assertNotEquals(actualPosition,targetPosition);
    controller.getTurnOwner().getSelectedUnit().moveTo(targetPosition);
    assertEquals(targetPosition,controller.getTurnOwner().getSelectedUnit().getLocation());
  }
}