package CharacterGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static CharacterGenerator.Kind.PLAYER;

public class CharacterGen implements CharacterGenerator {

    List<Character> enemyList = new ArrayList<Character>();
    List<Weapon> weaponList = new ArrayList<Weapon>();

    /**
     * Ask the user to input player information
     * @param sc
     * @return Character(Player Kind)
     */
    public Character loadPlayer(Scanner sc){
        System.out.println("Enter name for Character");
        String charName = sc.nextLine();

        System.out.println("Enter power for Character");
        int attackPower = Integer.parseInt(sc.nextLine());

        System.out.println("Enter defense for Character");
        int defense = Integer.parseInt(sc.nextLine());

        System.out.println("Enter health of Character");
        int health = Integer.parseInt(sc.nextLine());

        return new Character(charName, health, attackPower, defense, PLAYER);
    }

    public Weapon loadPlayerWeapon(Scanner sc) {

        System.out.println("Enter name for weapon or leave blank for none.");
        String weaponName = sc.nextLine();

        if (weaponName.trim().isEmpty()) {
            return null;
        }

        System.out.println("Enter power for Weapon");
        int attackPower = Integer.parseInt(sc.nextLine());

        System.out.println("Enter defense for Weapon");
        int defense = Integer.parseInt(sc.nextLine());

        return new Weapon(weaponName, attackPower, defense);
    }

    /**
     * Construct a list of enemies using scanner.
     * Populates enemyList
     * @param sc
     */
    public void setEnemyList(Scanner sc) {
        while (sc.hasNextLine()) {
            String charName = sc.nextLine();
            int attackPower = Integer.parseInt(sc.nextLine());
            int defense = Integer.parseInt(sc.nextLine());
            int health = Integer.parseInt(sc.nextLine());
            Kind kind = Kind.valueOf(sc.nextLine());

            Character currentEnemy = new Character(charName, health, attackPower, defense, kind);

            enemyList.add(currentEnemy);
        }
    }

    /**
     * Pulls a random character from enemyList
     * @return enemyList.get(randomNumber)
     */
    public Character getRandomCharacter() {
        Random r = new Random();
        int randomNumber = Math.abs(r.nextInt());
        randomNumber = randomNumber % enemyList.size();

        return enemyList.get(randomNumber);
    }

    /**
     * Construct a list of weapons using scanner.
     * Populates weaponList
     * @param sc
     */
    public void setWeaponList(Scanner sc) {
        while (sc.hasNextLine()) {
            String weaponName = sc.nextLine();
            int attackPower = Integer.parseInt(sc.nextLine());
            int defense = Integer.parseInt(sc.nextLine());

            Weapon currentWeapon = new Weapon(weaponName, attackPower, defense);

            weaponList.add(currentWeapon);
        }
    }

    /**
     * 50% chance to equip a weapon or not. Then return null or pulls a random weapon from weaponList.
     * @return weaponList.get(randomNumber) or null
     */
    public Weapon getRandomWeapon() {
        Random r = new Random();
        int randomNumber = Math.abs(r.nextInt());

        if (randomNumber % 2 == 0) {
            randomNumber = randomNumber % weaponList.size();
            return weaponList.get(randomNumber);
        } else {
            return null;
        }
    }
}
