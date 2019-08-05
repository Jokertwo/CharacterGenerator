package CharacterGenerator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;

public class JAXB {

    public JAXBEnemies loadEnemies(InputStream is) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(JAXBEnemies.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBEnemies enemies = (JAXBEnemies) unmarshaller.unmarshal(is);
        return enemies;
    }

    public void saveEnemies(String path, JAXBEnemies enemies) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(JAXBEnemies.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        // output pretty printed
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        File file = new File("enemies.xml");
        marshaller.marshal(enemies, file);
    }

    public JAXBWeapons loadWeapons(InputStream is) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(JAXBWeapons.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBWeapons weapons = (JAXBWeapons) unmarshaller.unmarshal(is);
        return weapons;
    }

    public void saveWeapons(String path, JAXBWeapons weapons) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(JAXBWeapons.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        // output pretty printed
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        File file = new File("weapons.xml");
        marshaller.marshal(weapons, file);
    }

}
