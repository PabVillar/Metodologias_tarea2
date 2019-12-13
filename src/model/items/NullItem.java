package model.items;

import model.units.*;

public class NullItem implements IEquipableItem{

    public IEquipableItem NullItem(){
        return null;
    }

    @Override
    public void equipTo(IUnit unit) {

    }

    @Override
    public IUnit getOwner() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getPower() {
        return 0;
    }

    @Override
    public int getMinRange() {
        return 0;
    }

    @Override
    public int getMaxRange() {
        return 0;
    }

    @Override
    public int versus(IEquipableItem item) {
        return 0;
    }

    @Override
    public int versusSword() {
        return 0;
    }

    @Override
    public int versusAxe() {
        return 0;
    }

    @Override
    public int versusBow() {
        return 0;
    }

    @Override
    public int versusSpear() {
        return 0;
    }

    @Override
    public int versusStaff() {
        return 0;
    }

    @Override
    public int versusLightMagicBook() {
        return 0;
    }

    @Override
    public int versusDarkMagicBook() {
        return 0;
    }

    @Override
    public int versusAenimaMagicBook() {
        return 0;
    }

    @Override
    public void equipToArcher(Archer archer) {

    }

    @Override
    public void equipToCleric(Cleric cleric) {

    }

    @Override
    public void equipToFighter(Fighter fighter) {

    }

    @Override
    public void equipToHero(Hero hero) {

    }

    @Override
    public void equipToSwordMaster(SwordMaster swordMaster) {

    }

    @Override
    public void equipToSorcerer(Sorcerer sorcerer) {

    }
}
