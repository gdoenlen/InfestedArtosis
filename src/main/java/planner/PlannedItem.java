package planner;

import bwapi.TilePosition;
import bwapi.UnitType;
import bwapi.UpgradeType;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

// TODO: Refactor with type reflection?
@Data
public class PlannedItem {
    private String uuid = UUID.randomUUID().toString();

    private PlanType type;
    private PlanState state = PlanState.PLANNED;

    // Simple prioritization, will increment elsewhere
    private int priority;
    private int frameStart;
    private int retries = 0;
    private int predictedReadyFrame = 0;

    // Block other plannedItem types in the queue
    private boolean blockOtherPlans;

    @Nullable
    private TilePosition buildPosition;

    @Nullable
    private UnitType plannedUnit;

    @Nullable
    private UpgradeType plannedUpgrade;

    public PlannedItem(UnitType unitType, int priority, boolean isBuilding, boolean isBlocking) {
        this.priority = priority;
        this.plannedUnit = unitType;
        this.type = isBuilding ? PlanType.BUILDING : PlanType.UNIT;
        this.blockOtherPlans = isBlocking;
    }

    public PlannedItem(UnitType unitType, int priority, boolean isBuilding, boolean isBlocking, TilePosition buildPosition) {
        this.priority = priority;
        this.plannedUnit = unitType;
        this.type = isBuilding ? PlanType.BUILDING : PlanType.UNIT;
        this.buildPosition = buildPosition;
        this.blockOtherPlans = isBlocking;
    }

    public PlannedItem(UpgradeType upgrade, int priority, boolean isBlocking) {
        this.priority = priority;
        this.plannedUpgrade = upgrade;
        this.type = PlanType.UPGRADE;
        this.blockOtherPlans = isBlocking;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof PlannedItem)) {
            return false;
        }

        PlannedItem u = (PlannedItem) o;

        return uuid == u.getUuid();
    }
    

    public String getName() {
        if (plannedUpgrade != null) {
            return plannedUpgrade.toString();
        } else if (plannedUnit != null) {
            return plannedUnit.toString();
        } else {
            return "NULL";
        }
    }
}
