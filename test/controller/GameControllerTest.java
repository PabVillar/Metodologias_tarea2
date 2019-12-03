package controller;

import model.items.*;
import model.units.*;
import model.Tactician;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

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
    controller = new GameController(4, 128);
    testTacticians = List.of("Player 0", "Player 1", "Player 2", "Player 3");
  }

  @Test
  void getTacticians() {
    List<Tactician> tacticians = controller.getTacticians();
    assertEquals(4, tacticians.size());
    for (int i = 0; i < tacticians.size(); i++) {
      assertEquals("Player " + i, tacticians.get(i + 1).getName());
    }
  }

  @Test
  void getGameMap() {
    Field gameMap = controller.getGameMap();
    assertEquals(128, gameMap.getSize()); // getSize deben definirlo
    assertTrue(controller.getGameMap().isConnected());
    Random testRandom = new Random(randomSeed);
    testRandom.setSeed(randomSeed);
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
    //Invariantes: Que los players existan
    List<Tactician> players = controller.getTacticians();
    assertEquals(4,players.size());
    Random testRandomPlayer = new Random(randomSeed);
    testRandomPlayer.setSeed(randomSeed);

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
    IntStream.range(0, 50).forEach(i -> {
      controller.initGame(randomTurnSequence.nextInt());
      assertEquals(randomTurnSequence.nextInt(), controller.getMaxRounds());
    });
    controller.initEndlessGame();
    assertEquals(-1, controller.getMaxRounds());
  }

  @Test
  void endTurn() {
    Tactician firstPlayer = controller.getTurnOwner();
    // Nuevamente, para determinar el orden de los jugadores se debe usar una semilla
    Tactician secondPlayer = new Tactician("Player 2"); // <- Deben cambiar esto (!)
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
    controller.getTacticians().forEach(tactician -> assertNotEquals("Player 1", tactician));
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
    assertTrue(List.of("Player 1", "Player 2").containsAll(winners));

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

    Archer archer = new Archer(50,2,new Location(0,0));

    controller.getTurnOwner().selectUnit(archer);
    controller.getTurnOwner().getSelectedUnit();

  }

  @Test
  void selectUnitIn() {

    assertNull(controller.getSelectedUnit());

    Sorcerer sorcerer = new Sorcerer(50,2,new Location (0,0));

    controller.selectUnitIn(0,0);

    assertEquals(sorcerer,controller.getSelectedUnit());

  }

  @Test
  void getItems() {
    Alpaca alpaca = new Alpaca(50,2,new Location(0,0));
    Bow bow = new Bow("bow",30,2,4);
    Sword sword = new Sword("sword",30,1,3);
    Axe axe = new Axe("axe",30,1,3);
    MagicBook aenimaMagicBook = new AenimaMagicBook("aenimaMagicBook",30,1,3);
    alpaca.addItems(bow);
    alpaca.addItems(sword);
    alpaca.addItems(axe);
    alpaca.addItems(aenimaMagicBook);

    controller.selectUnitIn(0,0);
    assertEquals(alpaca.getItems(),controller.getSelectedUnit().getItems());

  }

  @Test
  void equipItem() {
    Archer archer = new Archer(50,2,new Location(0,0));
    Bow bow = new Bow("bow",30,2,4);
    Sword sword = new Sword("sword",30,1,3);
    Axe axe = new Axe("axe",30,1,3);
    archer.addItems(bow);
    archer.addItems(sword);
    archer.addItems(axe);
    archer.equipItem(bow);

    controller.selectUnitIn(0,0);
    assertEquals(bow,controller.getSelectedUnit().getEquippedItem());

  }

  @Test
  void useItemOn() {
    Location l0 = new Location(0,0);
    Location l1 = new Location(0,1);

    l0.addNeighbour(l1);

    Hero hero = new Hero(50,2, l0);
    SwordMaster swordMaster = new SwordMaster(50,2,l1);

    Spear spear = new Spear("spear",30,1,3);
    Sword sword = new Sword("sword",30,1,3);

    hero.equipItem(spear);
    swordMaster.equipItem(sword);

    controller.selectUnitIn(0,0);
    controller.useItemOn(0,1);

    assertEquals(50-1.5*spear.getPower(),controller.getSelectedUnit().getCurrentHitPoints());

  }

  @Test
  void selectItem() {
    Cleric cleric = new Cleric(50,2,new Location(0,2));
    Staff staff_1 = new Staff("staff",30,1,3);
    Staff staff_2 = new Staff("staff_2",20,1,3);
    Staff staff_3 = new Staff("staff_3",10,1,3);

    cleric.addItems(staff_1);
    cleric.addItems(staff_2);
    cleric.addItems(staff_3);

    controller.selectUnitIn(0,2);
    controller.selectItem(1);

    assertEquals(cleric.getItems().get(1),controller.getSelectedItem());

  }

  @Test
  void getSelectedItem(){

  }

  @Test
  void giveItemTo() {
    Location l0 = new Location(0,0);
    Location l1 = new Location(0,1);
    l0.addNeighbour(l1);

    Archer archer = new Archer(50,2,l0);
    Sorcerer sorcerer = new Sorcerer(50,2,l1);

    Bow bow = new Bow("bow",30,2,4);
    DarkMagicBook darkMagicBook = new DarkMagicBook("darkMagicBook",30,1,3);

    archer.addItems(bow);
    sorcerer.addItems(darkMagicBook);

    controller.selectUnitIn(0,0);
    controller.selectItem(0);
    controller.giveItemTo(0,1);

    assertEquals(bow,sorcerer.getItems().get(1));

  }
}