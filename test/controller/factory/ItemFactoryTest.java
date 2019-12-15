package controller.factory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import controller.factory.itemFactory.*;

import model.items.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemFactoryTest {
    private AenimaMagicBookFactory aenimaMagicBookFactory;
    private AxeFactory axeFactory;
    private BowFactory bowFactory;
    private DarkMagicBookFactory darkMagicBookFactory;
    private LightMagicBookFactory lightMagicBookFactory;
    private SpearFactory spearFactory;
    private StaffFactory staffFactory;
    private SwordFactory swordFactory;
    private ItemFactory itemFactory;


    @BeforeEach
    void setUp(){
        aenimaMagicBookFactory = new AenimaMagicBookFactory();
        axeFactory = new AxeFactory();
        bowFactory = new BowFactory();
        darkMagicBookFactory = new DarkMagicBookFactory();
        lightMagicBookFactory = new LightMagicBookFactory();
        spearFactory = new SpearFactory();
        staffFactory = new StaffFactory();
        swordFactory = new SwordFactory();

        aenimaMagicBookFactory.setName("aenimaMagicBook");
        aenimaMagicBookFactory.setPower(10);
        aenimaMagicBookFactory.setMinRange(1);
        aenimaMagicBookFactory.setMaxRange(2);


        axeFactory.setName("axe");
        axeFactory.setPower(10);
        axeFactory.setMinRange(1);
        axeFactory.setMaxRange(2);

        bowFactory.setName("bow");
        bowFactory.setPower(20);
        bowFactory.setMinRange(2);
        bowFactory.setMaxRange(4);

        darkMagicBookFactory.setName("darkMagicBook");
        darkMagicBookFactory.setPower(10);
        darkMagicBookFactory.setMinRange(1);
        darkMagicBookFactory.setMaxRange(2);


        lightMagicBookFactory.setName("lightMagicBook");
        lightMagicBookFactory.setPower(10);
        lightMagicBookFactory.setMinRange(1);
        lightMagicBookFactory.setMaxRange(2);

        spearFactory.setName("spear");
        spearFactory.setPower(10);
        spearFactory.setMinRange(1);
        spearFactory.setMaxRange(2);


        staffFactory.setName("staff");
        staffFactory.setPower(10);
        staffFactory.setMinRange(1);
        staffFactory.setMaxRange(2);

        swordFactory.setName("sword");
        swordFactory.setPower(10);
        swordFactory.setMinRange(1);
        swordFactory.setMaxRange(2);



    }

    @Test
    public void setAenimaMagicBookFactory(){


        assertEquals("aenimaMagicBook",aenimaMagicBookFactory.getName());
        assertEquals(10,aenimaMagicBookFactory.getPower());
        assertEquals(1,aenimaMagicBookFactory.getMinRange());
        assertEquals(2,aenimaMagicBookFactory.getMaxRange());

    }

    @Test
    public void setAxeFactory(){


        assertEquals("axe",axeFactory.getName());
        assertEquals(10,axeFactory.getPower());
        assertEquals(1,axeFactory.getMinRange());
        assertEquals(2,axeFactory.getMaxRange());
    }

    @Test
    public void setBowFactory(){


        assertEquals("bow",bowFactory.getName());
        assertEquals(20,bowFactory.getPower());
        assertEquals(2,bowFactory.getMinRange());
        assertEquals(4,bowFactory.getMaxRange());
    }

    @Test
    public void setDarkMagicBookFactory(){


        assertEquals("darkMagicBook",darkMagicBookFactory.getName());
        assertEquals(10,darkMagicBookFactory.getPower());
        assertEquals(1,darkMagicBookFactory.getMinRange());
        assertEquals(2,darkMagicBookFactory.getMaxRange());

    }

    @Test
    public void setLightMagicBookFactory(){


        assertEquals("lightMagicBook",lightMagicBookFactory.getName());
        assertEquals(10,lightMagicBookFactory.getPower());
        assertEquals(1,lightMagicBookFactory.getMinRange());
        assertEquals(2,lightMagicBookFactory.getMaxRange());

    }

    @Test
    public void setSpearFactory(){


        assertEquals("spear",spearFactory.getName());
        assertEquals(10,spearFactory.getPower());
        assertEquals(1,spearFactory.getMinRange());
        assertEquals(2,spearFactory.getMaxRange());
    }

    @Test
    public void setStaffFactory(){


        assertEquals("staff",staffFactory.getName());
        assertEquals(10,staffFactory.getPower());
        assertEquals(1,staffFactory.getMinRange());
        assertEquals(2,staffFactory.getMaxRange());
    }

    @Test
    public void setSwordFactory(){


        assertEquals("sword",swordFactory.getName());
        assertEquals(10,swordFactory.getPower());
        assertEquals(1,swordFactory.getMinRange());
        assertEquals(2,swordFactory.getMaxRange());
    }

    @Test
    public void createAenimaMagicBook(){
        AenimaMagicBook aenimaMagicBook = aenimaMagicBookFactory.create(aenimaMagicBookFactory.getName(),
                aenimaMagicBookFactory.getPower(),
                aenimaMagicBookFactory.getMinRange(),
                aenimaMagicBookFactory.getMaxRange());
        assertEquals(AenimaMagicBook.class,aenimaMagicBook.getClass());
        assertEquals("aenimaMagicBook",aenimaMagicBook.getName());
        assertEquals(10,aenimaMagicBook.getPower());
        assertEquals(1,aenimaMagicBook.getMinRange());
        assertEquals(2,aenimaMagicBook.getMaxRange());

    }

    @Test
    public void createAxe(){
        Axe axe = axeFactory.create(axeFactory.getName(),
                axeFactory.getPower(),
                axeFactory.getMinRange(),
                axeFactory.getMaxRange());

        assertEquals(Axe.class,axe.getClass());
        assertEquals("axe",axe.getName());
        assertEquals(10,axe.getPower());
        assertEquals(1,axe.getMinRange());
        assertEquals(2,axe.getMaxRange());
    }

    @Test
    public void createBow(){
        Bow bow = bowFactory.create(bowFactory.getName(),
                bowFactory.getPower(),
                bowFactory.getMinRange(),
                bowFactory.getMaxRange());

        assertEquals(Bow.class,bow.getClass());
        assertEquals("bow",bow.getName());
        assertEquals(20,bow.getPower());
        assertEquals(2,bow.getMinRange());
        assertEquals(4,bow.getMaxRange());
    }


    @Test
    public void createDarkMagicBook(){
        DarkMagicBook darkMagicBook = darkMagicBookFactory.create(darkMagicBookFactory.getName(),
                darkMagicBookFactory.getPower(),
                darkMagicBookFactory.getMinRange(),
                darkMagicBookFactory.getMaxRange());

        assertEquals(DarkMagicBook.class,darkMagicBook.getClass());
        assertEquals("darkMagicBook",darkMagicBook.getName());
        assertEquals(10,darkMagicBook.getPower());
        assertEquals(1,darkMagicBook.getMinRange());
        assertEquals(2,darkMagicBook.getMaxRange());

    }

    @Test
    public void createLightMagicBook(){
        LightMagicBook lightMagicBook = lightMagicBookFactory.create(lightMagicBookFactory.getName(),
                lightMagicBookFactory.getPower(),
                lightMagicBookFactory.getMinRange(),
                lightMagicBookFactory.getMaxRange());

        assertEquals(LightMagicBook.class,lightMagicBook.getClass());
        assertEquals("lightMagicBook",lightMagicBook.getName());
        assertEquals(10,lightMagicBook.getPower());
        assertEquals(1,lightMagicBook.getMinRange());
        assertEquals(2,lightMagicBook.getMaxRange());

    }

    @Test
    public void createSpear() {
        Spear spear = spearFactory.create(spearFactory.getName(),
                spearFactory.getPower(),
                spearFactory.getMinRange(),
                spearFactory.getMaxRange());

        assertEquals(Spear.class, spear.getClass());
        assertEquals("spear", spear.getName());
        assertEquals(10, spear.getPower());
        assertEquals(1, spear.getMinRange());
        assertEquals(2, spear.getMaxRange());
    }

    @Test
    public void createStaff(){
        Staff staff = staffFactory.create(staffFactory.getName(),
                staffFactory.getPower(),
                staffFactory.getMinRange(),
                staffFactory.getMaxRange());

        assertEquals(Staff.class,staff.getClass());
        assertEquals("staff",staff.getName());
        assertEquals(10,staff.getPower());
        assertEquals(1,staff.getMinRange());
        assertEquals(2,staff.getMaxRange());
    }

    @Test
    public void createSword(){
        Sword sword = swordFactory.create(swordFactory.getName(),
                swordFactory.getPower(),
                swordFactory.getMinRange(),
                swordFactory.getMaxRange());

        assertEquals(Sword.class,sword.getClass());
        assertEquals("sword",sword.getName());
        assertEquals(10,sword.getPower());
        assertEquals(1,sword.getMinRange());
        assertEquals(2,sword.getMaxRange());
    }

    @Test
    public void getItemTest(){

        IEquipableItem axe = itemFactory.getItem(axeFactory);

        assertEquals(Axe.class,axe.getClass());
    }









}
