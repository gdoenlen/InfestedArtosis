package strategy.openers;

import bwapi.UnitType;
import planner.PlannedItem;

import java.util.ArrayList;
import java.util.List;

public class FourPool implements Opener {

    public OpenerName getName() { return OpenerName.FOUR_POOL; }

    public List<PlannedItem> getBuildOrder() {

        List<PlannedItem> list = new ArrayList<>();
        list.add(new PlannedItem(UnitType.Zerg_Spawning_Pool, 0, true, true ));
        list.add(new PlannedItem(UnitType.Zerg_Drone, 1, false, true));
        list.add(new PlannedItem(UnitType.Zerg_Zergling, 2, false, false));
        list.add(new PlannedItem(UnitType.Zerg_Zergling, 2, false, false));
        list.add(new PlannedItem(UnitType.Zerg_Zergling, 2, false, false));
        list.add(new PlannedItem(UnitType.Zerg_Zergling, 2, false, false));
        list.add(new PlannedItem(UnitType.Zerg_Zergling, 2, false, false));

        return list;
    }

    public boolean playsFourPlayerMap() {
        return false;
    }

    public boolean isAllIn() { return true; }
}
