package CharacterGenerator;

public class Weapon {

    private String name;
    private int attack;
    private int defend;


    public Weapon(String name, int attack, int defend) {

        this.name = name;
        this.attack = attack;
        this.defend = defend;

    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefend() {
        return this.defend;
    }

}
