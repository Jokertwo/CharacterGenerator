package CharacterGenerator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "weapons")
public class JAXBWeapons {

    @XmlElement(name = "weapon")
    private List<JAXBWeapon> weapons2;

    public void setWeapons(List<JAXBWeapon> weapons) {
        this.weapons2 = weapons;
    }

    public List<JAXBWeapon> getWeapons() {
        return weapons2;
    }
}
