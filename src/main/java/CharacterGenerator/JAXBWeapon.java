package CharacterGenerator;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "weapon")
public class JAXBWeapon {

    @XmlAttribute(name = "weaponName")
    private String weaponName;

    @XmlElement(name = "attack")
    private int attack;

    @XmlElement(name = "defense")
    private int defense;

    public JAXBWeapon() {
    }

    public JAXBWeapon(String weaponName, int attack, int defense) {
        this.weaponName = weaponName;
        this.attack = attack;
        this.defense = defense;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }
}
