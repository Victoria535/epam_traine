package builder;

import factory.AccessoryFactory;
import model.accessories.Accessory;
import model.enums.AccessoryColorType;
import model.enums.AccessoryType;

import java.util.ArrayList;
import java.util.List;

public final class AccessoryBuilder {

    private AccessoryBuilder() {
    }

    /**
     * This method create accessories in bouquet.
     *
     * @return accessories
     */
    public static List<Accessory> createAccessories() {
        List<Accessory> accessories = new ArrayList<>();
        AccessoryFactory accessoryFactory = new AccessoryFactory();

        Accessory accessoryWrapper = accessoryFactory.createAccessories(AccessoryType.WRAPPER);
        accessoryWrapper.setAccessoryColor(AccessoryColorType.BLUE);
        accessories.add(accessoryWrapper);

        Accessory accessoryRibbon = accessoryFactory.createAccessories(AccessoryType.RIBBON);
        accessoryRibbon.setAccessoryColor(AccessoryColorType.BLUE);
        accessories.add(accessoryRibbon);
        return accessories;
    }
}
