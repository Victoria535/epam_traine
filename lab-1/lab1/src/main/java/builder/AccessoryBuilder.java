package builder;

import factory.AccessoryFactory;
import model.accessories.Accessory;
import model.enums.AccessoryColor;
import model.enums.AccessoryType;

import java.util.ArrayList;
import java.util.List;

/**
 * Accessory builder.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public final class AccessoryBuilder {
    /**
     * Constructor.
     */
    private AccessoryBuilder() {
    }

    /**
     * This method create accessories in bouquet.
     *
     * @return accessories List<Accessory> accessories
     */
    public static List<Accessory> createAccessories() {
        List<Accessory> accessories = new ArrayList<>();
        AccessoryFactory accessoryFactory = new AccessoryFactory();

        Accessory accessoryWrapper = accessoryFactory.create(AccessoryType.WRAPPER);
        accessoryWrapper.setAccessoryColor(AccessoryColor.BLUE);
        accessories.add(accessoryWrapper);

        Accessory accessoryRibbon = accessoryFactory.create(AccessoryType.RIBBON);
        accessoryRibbon.setAccessoryColor(AccessoryColor.RED);
        accessories.add(accessoryRibbon);
        return accessories;
    }
}
