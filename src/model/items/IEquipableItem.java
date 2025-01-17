package model.items;

import model.units.*;

/**
 * This interface represents the <i>weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IEquipableItem {

  /**
   * Equips this item to a unit.
   *
   * @param unit
   *     the unit that will be quipped with the item
   */
  void equipTo(IUnit unit);


  /**
   * @return the unit that has currently equipped this item
   */
  IUnit getOwner();

  /**
   * @return the name of the item
   */
  String getName();

  /**
   * @return the power of the item
   */
  int getPower();

  /**
   * @return the minimum range of the item
   */
  int getMinRange();

  /**
   * @return the maximum range of the item
   */
  int getMaxRange();

  int versus(IEquipableItem item);

  int versusSword();

  int versusAxe();

  int versusBow();

  int versusSpear();

  int versusStaff();

  int versusLightMagicBook();

  int versusDarkMagicBook();

  int versusAenimaMagicBook();

  void equipToArcher(Archer archer);

  void equipToCleric(Cleric cleric);

    void equipToFighter(Fighter fighter);

    void equipToHero(Hero hero);

    void equipToSwordMaster(SwordMaster swordMaster);

    void equipToSorcerer(Sorcerer sorcerer);
}
