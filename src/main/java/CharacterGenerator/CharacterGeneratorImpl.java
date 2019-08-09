package CharacterGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static CharacterGenerator.Kind.PLAYER;

public class CharacterGeneratorImpl implements CharacterGenerator {

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
}
