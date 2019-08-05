package CharacterGenerator;

import java.util.List;
import java.util.Scanner;

public interface CharacterGenerator {

    /**
     * Ask the user to input player information
     * @param sc
     * @return Character(Player Kind)
     */
    Character loadPlayer(Scanner sc);
    Weapon loadPlayerWeapon(Scanner sc);

    /**
     * Construct a list of enemies using scanner.
     * Populates enemyList
     * @param sc
     */
    void setEnemyList(List<Character> characterList);

    /**
     * Pulls a random character from enemyList
     * @return enemyList.get(randomNumber)
     */
    Character getRandomCharacter();

    List<Character> getEnemyList();

    /**
     *
     * Populates weaponList
     * @param sc
     */
    void setWeaponList(List<Weapon> weaponsList);

    /**
     * 50% chance to equip a weapon or not. Then return null or pulls a random weapon from weaponList.
     * @return weaponList.get(randomNumber) or null
     */
    Weapon getRandomWeapon();

    List<Weapon> getWeaponList();

}
