package strategy.strategies;

import bwapi.UnitType;
import planner.PlannedItem;
import strategy.openers.Opener;

import java.util.List;
import java.util.Map;
import java.util.Set;

// Represent desired unit types and mix for strategy
//
// Represent tech options as a tree, if root can be made, add to queue w/ high priority
public interface Strategy {
    default String getName() {
        return this.getClass().getSimpleName();
    }

    // Gets default unit weights for strategy
    // Can reconfigure these later with game state
    UnitWeights getUnitWeights();

    boolean playsOpener(Opener opener);
}
