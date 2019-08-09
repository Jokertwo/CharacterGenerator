package CharacterGenerator;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CharacterFactory {

    List<Character> enemyList = new ArrayList<Character>();
    List<Weapon> weaponList = new ArrayList<Weapon>();

    /**
     * Initialize the enemyList by reading the XML file enemies.xml
     * @return List<Character> characterList
     */
    public void initCharactersList() {
        File enemyList = new File("C:\\Users\\Matt\\Documents\\TestProjects\\CharacterGenerator\\src\\main\\resources\\enemies.xml");
        JAXB jaxb = new JAXB();
        List<JAXBEnemy> jaxbEnemies;
        JAXBEnemies enemies;
        List<Character> characterList = new ArrayList<>();

        try {
            InputStream is = new FileInputStream(enemyList);
            try {
                enemies = jaxb.loadEnemies(is);
                jaxbEnemies = enemies.getEnemies();
                for (int i = 0; i < jaxbEnemies.size(); i++){
                    Character tempCharacter = new Character(jaxbEnemies.get(i).getCharName(), jaxbEnemies.get(i).getHealth(), jaxbEnemies.get(i).getAttack(), jaxbEnemies.get(i).getDefense(), jaxbEnemies.get(i).getKind());
                    characterList.add(tempCharacter);
                }
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.enemyList = characterList;
    }

    /**
     * Initialize the weaponList by reading the XML file weapons.xml
     * @return List<Weapon> weaponsList
     */
    public void initWeaponsList() {
        File weaponList = new File("C:\\Users\\Matt\\Documents\\TestProjects\\CharacterGenerator\\src\\main\\resources\\weapons.xml");
        JAXB jaxb = new JAXB();
        List<JAXBWeapon> jaxbWeapons;
        JAXBWeapons weapons;
        List<Weapon> weaponsList = new ArrayList<>();

        try {
            InputStream is = new FileInputStream(weaponList);
            try {
                weapons = jaxb.loadWeapons(is);
                jaxbWeapons = weapons.getWeapons();
                for (int i = 0; i < jaxbWeapons.size(); i++){
                    Weapon tempWeapon = new Weapon(jaxbWeapons.get(i).getWeaponName(), jaxbWeapons.get(i).getAttack(),jaxbWeapons.get(i).getDefense());
                    weaponsList.add(tempWeapon);
                }
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.weaponList = weaponsList;
    }

    public Character getRandomCharacter() {
        Random r = new Random();
        int randomNumber = Math.abs(r.nextInt());
        randomNumber = randomNumber % enemyList.size();

        return enemyList.get(randomNumber);
    }

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
