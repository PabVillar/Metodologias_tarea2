package controller.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import controller.factory.unitFactory.*;

import model.units.*;

import model.map.Location;
import model.units.IUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitFactoryTest {
    private AlpacaFactory alpacaFactory;
    private ArcherFactory archerFactory;
    private ClericFactory clericFactory;
    private FighterFactory fighterFactory;
    private HeroFactory heroFactory;
    private SorcererFactory sorcererFactory;
    private SwordMasterFactory swordMasterFactory;
    private UnitFactory unitFactory;


    @BeforeEach
    void setUp(){
        alpacaFactory = new AlpacaFactory();
        archerFactory = new ArcherFactory();
        clericFactory = new ClericFactory();
        fighterFactory = new FighterFactory();
        heroFactory = new HeroFactory();
        sorcererFactory = new SorcererFactory();
        swordMasterFactory = new SwordMasterFactory();

        alpacaFactory.setLocation(new Location(0,0));
        archerFactory.setLocation(new Location(0,1));
        clericFactory.setLocation(new Location(0,2));
        fighterFactory.setLocation(new Location(1,0));
        heroFactory.setLocation(new Location(1,1));
        sorcererFactory.setLocation(new Location(1,2));
        swordMasterFactory.setLocation(new Location(2,0));

    }

    @Test
    public void createAlpaca(){
        Alpaca alpaca = alpacaFactory.create(alpacaFactory.getHitPoints(),
                alpacaFactory.getMovement(),
                alpacaFactory.getLocation());

        assertEquals(Alpaca.class,alpaca.getClass());
        assertEquals(alpacaFactory.getHitPoints(),alpaca.getCurrentHitPoints());
        assertEquals(alpacaFactory.getMovement(),alpaca.getMovement());
        assertEquals(alpacaFactory.getLocation(),alpaca.getLocation());
    }

    @Test
    public void createArcher(){
        Archer archer = archerFactory.create(archerFactory.getHitPoints(),
                archerFactory.getMovement(),
                archerFactory.getLocation());

        assertEquals(Archer.class,archer.getClass());
        assertEquals(archerFactory.getHitPoints(),archer.getCurrentHitPoints());
        assertEquals(archerFactory.getMovement(),archer.getMovement());
        assertEquals(archerFactory.getLocation(),archer.getLocation());
    }

    @Test
    public void createCleric(){
        Cleric cleric = clericFactory.create(clericFactory.getHitPoints(),
                clericFactory.getMovement(),
                clericFactory.getLocation());

        assertEquals(Cleric.class,cleric.getClass());
        assertEquals(clericFactory.getHitPoints(),cleric.getCurrentHitPoints());
        assertEquals(clericFactory.getMovement(),cleric.getMovement());
        assertEquals(clericFactory.getLocation(),cleric.getLocation());
    }

    @Test
    public void createFighter(){
        Fighter fighter = fighterFactory.create(fighterFactory.getHitPoints(),
                fighterFactory.getMovement(),
                fighterFactory.getLocation());

        assertEquals(Fighter.class,fighter.getClass());
        assertEquals(fighterFactory.getHitPoints(),fighter.getCurrentHitPoints());
        assertEquals(fighterFactory.getMovement(),fighter.getMovement());
        assertEquals(fighterFactory.getLocation(),fighter.getLocation());
    }

    @Test
    public void createHero(){
        Hero hero = heroFactory.create(heroFactory.getHitPoints(),
                heroFactory.getMovement(),
                heroFactory.getLocation());

        assertEquals(Hero.class,hero.getClass());
        assertEquals(heroFactory.getHitPoints(),hero.getCurrentHitPoints());
        assertEquals(heroFactory.getMovement(),hero.getMovement());
        assertEquals(heroFactory.getLocation(),hero.getLocation());
    }

    @Test
    public void createSorcerer(){
        Sorcerer sorcerer = sorcererFactory.create(sorcererFactory.getHitPoints(),
                sorcererFactory.getMovement(),
                sorcererFactory.getLocation());

        assertEquals(Sorcerer.class,sorcerer.getClass());
        assertEquals(sorcererFactory.getHitPoints(),sorcerer.getCurrentHitPoints());
        assertEquals(sorcererFactory.getMovement(),sorcerer.getMovement());
        assertEquals(sorcererFactory.getLocation(),sorcerer.getLocation());
    }

    @Test
    public void createSwordMaster(){
        SwordMaster swordMaster = swordMasterFactory.create(swordMasterFactory.getHitPoints(),
                swordMasterFactory.getMovement(),
                swordMasterFactory.getLocation());

        assertEquals(SwordMaster.class,swordMaster.getClass());
        assertEquals(swordMasterFactory.getHitPoints(),swordMaster.getCurrentHitPoints());
        assertEquals(swordMasterFactory.getMovement(),swordMaster.getMovement());
        assertEquals(swordMasterFactory.getLocation(),swordMaster.getLocation());
    }

    @Test
    public void getUnitTest(){
        IUnit sorcerer = unitFactory.getUnit(sorcererFactory);

        assertEquals(Sorcerer.class,sorcerer.getClass());
    }

}
