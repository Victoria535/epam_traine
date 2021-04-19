package factory;

import model.accessories.Accessory;
import model.accessories.Ribbon;
import model.accessories.Toy;
import model.accessories.Wrapper;
import model.enums.AccessoryType;

import java.util.logging.Logger;

public class AccessoryFactory {
    private static Logger logger = Logger.getLogger(AccessoryFactory.class.toString());

    public Accessory createAccessories(AccessoryType type) {
        Accessory accessory = null;
        switch (type) {
            case WRAPPER:
                accessory = new Wrapper();
                accessory.setName("Wrapper");
                accessory.setCost(4);
                break;
            case RIBBON:
                accessory = new Ribbon();
                accessory.setName("Ribbon");
                accessory.setCost(2);
                break;
            case TOY:
                accessory = new Toy();
                accessory.setName("Toy");
                accessory.setCost(5);
                break;
            default:
                logger.info("Unknown value.");
        }
        return accessory;
    }
}

