package CharacterGenerator;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "enemy")
public class JAXBEnemy {

    @XmlAttribute(name = "charName")
    private String charName;

    @XmlElement(name = "attack")
    private int attack;

    @XmlElement(name = "defense")
    private int defense;

    @XmlElement(name = "health")
    private int health;

    @XmlElement(name = "kind")
    private Kind kind;

    public JAXBEnemy() {
    }

    public JAXBEnemy(String charName, int attack, int defense, int health, Kind kind) {
        this.charName = charName;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.kind = kind;
    }

    public String getCharName() {
        return charName;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() { return attack; }

    public Kind getKind() { return kind; }
}