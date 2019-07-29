package CharacterGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args){

        //Create the player character
        Scanner playerInput = new Scanner(System.in);
        CharacterGen characterGenerator = new CharacterGen();
        Character player = characterGenerator.loadPlayer(playerInput);
        playerInput.close();

        //Compile the ArrayList of enemies from the file
        Scanner enemyInput = null;
        File enemyList = new File("C:\\Users\\Matt\\Documents\\CharacterGenerator\\src\\enemies.txt");
        try {
            enemyInput = new Scanner(enemyList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        characterGenerator.setEnemyList(enemyInput);

        //Get some random character from the ArrayList.
        Character enemy = characterGenerator.getRandomCharacter();

        System.out.println(player.getName());
        System.out.println(enemy.getName());
    }

}
