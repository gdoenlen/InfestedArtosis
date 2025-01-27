package unit.squad;

import bwapi.Position;
import lombok.Data;
import planner.PlannedItem;
import unit.managed.ManagedUnit;

import java.util.HashSet;
import java.util.UUID;

@Data
/**
 * Bundles up managed units that should be functioning together to perform a goal.
 * TODO: Squad merging/splitting
 * TODO: Debug squads
 * TODO: Move into new namespace
 */
public class Squad {

    private String id = UUID.randomUUID().toString();

    private HashSet<ManagedUnit> members = new HashSet<>();

    private Position center;
    private int radius;

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PlannedItem)) {
            return false;
        }

        Squad s = (Squad) other;

        return s.getId() == this.getId();
    }

    public int distance (Squad other) {
        return (int) center.getDistance(other.getCenter());
    }

    public int distance (ManagedUnit managedUnit) {
        return (int) center.getDistance(managedUnit.getUnit().getPosition());
    }

    public void onFrame() {
        calculateCenter();
    }

    public void addUnit(ManagedUnit managedUnit) {
        members.add(managedUnit);
    }

    public void removeUnit(ManagedUnit managedUnit) {
        members.remove(managedUnit);
    }

    public int size() { return members.size(); }

    public boolean containsManagedUnit(ManagedUnit managedUnit) {
        return members.contains(managedUnit);
    }

    public void merge(Squad other) {
        for (ManagedUnit managedUnit: other.getMembers()) {
            members.add(managedUnit);
        }
    }

    private void calculateCenter() {
        int x, y;
        x = y = 0;

        for (ManagedUnit managedUnit: members) {
            Position position = managedUnit.getUnit().getPosition();
            x += position.getX();
            y += position.getY();
        }

        this.center = new Position(x / members.size(), y / members.size());
    }
}
