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



}
