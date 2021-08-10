package characters;

public class Hero {

    public String name;

    public int hp;
    public int mana;

    public int strength;

    public Hero(String name, int hp, int mana, int strength) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
