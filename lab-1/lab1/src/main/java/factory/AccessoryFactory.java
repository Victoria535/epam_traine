package factory;

import model.accessories.Accessory;
import model.accessories.Ribbon;
import model.accessories.Toy;
import model.accessories.Wrapper;
import model.enums.AccessoryType;
import worker.Printable;


/**
 * Accessory factory for create accessories.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public class AccessoryFactory implements Factory<Accessory, AccessoryType> {

    @Override
    public Accessory create(AccessoryType type) {
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
                Printable.printInfo("Unknown value.");
        }
        return accessory;
    }
}
