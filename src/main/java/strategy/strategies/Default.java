package strategy.strategies;

import bwapi.UnitType;
import strategy.openers.Opener;

import java.util.HashMap;
import java.util.Map;

/**
 * Default strategy, reflecting the original hardcoded unit mix
 */
public class Default implements Strategy {

    public UnitWeights getUnitWeights() {
        UnitWeights weights = new UnitWeights();
        weights.setWeight(UnitType.Zerg_Zergling, 0.5);
        weights.setWeight(UnitType.Zerg_Hydralisk, 0.5);
        return weights;
    }
    @Override
    public boolean playsOpener(Opener opener) {
        switch(opener.getName()) {
            case TWELVE_HATCH:
            case FIVE_POOL:
            case OVER_POOL:
            case NINE_POOL_SPEED:
                return true;
            default:
                return false;
        }
    }

}
