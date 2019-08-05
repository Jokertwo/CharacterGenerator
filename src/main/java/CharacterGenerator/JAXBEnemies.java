package CharacterGenerator;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "enemies")
public class JAXBEnemies {

    @XmlElement(name = "enemy")
    private List<JAXBEnemy> enemies2;

    public void setEnemies(List<JAXBEnemy> enemies) {
        this.enemies2 = enemies;
    }

    public List<JAXBEnemy> getEnemies() {
        return enemies2;
    }

}