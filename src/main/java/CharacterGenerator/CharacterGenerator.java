package CharacterGenerator;

import java.util.Scanner;

public interface CharacterGenerator {

    Character loadPlayer(Scanner sc);
    Character getRandomCharacter();

}
