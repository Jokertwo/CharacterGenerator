package CharacterGenerator;

import java.util.ArrayList;
import java.util.List;


public class Character {

    private String characterName;
    private int characterHealth;
    private int attackDamage;
    private int defense;
    private CharacterArm leftArm;
    private CharacterArm rightArm;
    private Kind kind;
    private List<Weapon> weaponsList = new ArrayList<Weapon>();


    public Character(String name, int health, int attack, int defense, Kind kind){
        this.characterName = name;
        this.characterHealth = health;
        this.attackDamage = attack;
        this.defense = defense;
        this.leftArm = new CharacterArm(Arm.LEFT);
        this.rightArm = new CharacterArm(Arm.RIGHT);
        this.kind = kind;
    }

    /**
     * Find out if character has weapons and if yes, return a list of weapons.
     * @return weaponsList
     */
    public List<Weapon> getLoot() {
        if(rightArm.getWeapon() != null) {
            weaponsList.add(rightArm.getWeapon());
        }
        if(leftArm.getWeapon() != null) {
            weaponsList.add(leftArm.getWeapon());
        }

        return weaponsList;
    }

    public Kind getKind() {
        return kind;
    }

    public int getDefense(){ return defense; }

    public int getCharacterHealth() {
        return characterHealth;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public String getName(){
        return characterName;
    }

    /**
     * Check if character has weapons. If yes, assign the weapons the respective arm.
     * @param arm
     * @param weapon
     * @return false if character has no weapons.
     */
    public boolean takeWeapon(Arm arm, Weapon weapon) {

        if(arm == rightArm.getArm()){
            if(rightArm.getWeapon() == null){
                rightArm.setWeapon(weapon);
                return true;
            }
        }
        if(arm == leftArm.getArm()){
            if(leftArm.getWeapon() == null){
                leftArm.setWeapon(weapon);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param enemyAttack
     * @return remainingHealth
     */
        public int characterDefend(int enemyAttack) {

        int remainingHealth = characterHealth;
        int totalDefense = 0;

        if(enemyAttack <= 0){
            return  remainingHealth;
        }

        if(leftArm.hasWeapon() == true){
            totalDefense = totalDefense + leftArm.getWeapon().getDefend();
        }
        if(rightArm.hasWeapon() == true){
            totalDefense = totalDefense + rightArm.getWeapon().getDefend();
        }

        totalDefense = totalDefense + defense;

        if(totalDefense < enemyAttack){
            remainingHealth = remainingHealth - (enemyAttack - totalDefense);
        }


        characterHealth = remainingHealth;
        return characterHealth;
    }

    /**
     * Calculate character's total attack from base attack + weapons
     * @return totalAttack
     */
    public int characterAttack(){

        int totalAttack = attackDamage;

        if(leftArm.hasWeapon() == true){
            totalAttack = totalAttack + leftArm.getWeapon().getAttack();
        }
        if(rightArm.hasWeapon() == true){
            totalAttack = totalAttack + rightArm.getWeapon().getAttack();
        }

        return totalAttack;
    }

    /**
     * Check if character is alive
     * @return true if health > 0
     */
    public boolean isAlive() {

        if (characterHealth > 0){
            return true;
        }
        else {
            return false;
        }
    }
}
