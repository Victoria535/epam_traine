package factory;

import model.enums.FlowerType;
import model.flowers.Chamomile;
import model.flowers.Flower;
import model.flowers.Rose;
import model.flowers.Tulip;

import java.util.logging.Logger;

public class FlowerFactory {
    private static final Logger LOGGER = Logger.getLogger(FlowerFactory.class.toString());

    public Flower createFlower(FlowerType type) {
        Flower flower = null;
        switch (type) {
            case ROSE:
                flower = new Rose();
                flower.setName("Rose");
                flower.setCost(7);
                flower.setFresh(1);
                flower.setStemLength(60);
                break;
            case CHAMOMILE:
                flower = new Chamomile();
                flower.setName("Chamomile");
                flower.setCost(2);
                flower.setFresh(2);
                flower.setStemLength(35.5);
                break;
            case TULIP:
                flower = new Tulip();
                flower.setName("Tulip");
                flower.setCost(3);
                flower.setFresh(3);
                flower.setStemLength(20);
                break;
            default:
                LOGGER.info("Unknown value.");
        }
        return flower;
    }
}
