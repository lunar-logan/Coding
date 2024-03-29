package org.coding.parkinglot.domain;

import org.coding.common.annotation.Nullable;

import java.util.*;

public class ParkingLot {
    @Nullable
    private Integer id;
    private List<ParkingFloor> floors;

    // region Constructor, getters, setters, equals, hashCode, toString -- generated by BoB the Builder of Beans
    // The code below has been generated by BoB the Builder of Beans based on the class' fields.
    // Everything after this comment will be regenerated if you invoke BoB again.
    // If you don't know who BoB is, you can find him here: https://bitbucket.org/atlassianlabs/bob-the-builder-of-beans

    public ParkingLot(@Nullable Integer id, Collection<ParkingFloor> floors) {
        this.id = id;
        this.floors = new ArrayList<>(Objects.requireNonNull(floors));
    }

    // region Getters and setters -- generated by BoB the Builder of Beans
    public Optional<Integer> getId() {
        return Optional.ofNullable(id);
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = new ArrayList<>(Objects.requireNonNull(floors));
    }// endregion Getters and setters

    // region hashCode() and equals() -- generated by BoB the Builder of Beans
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ParkingLot that = (ParkingLot) o;

        return Objects.equals(this.getId(), that.getId()) && Objects.equals(this.getFloors(), that.getFloors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFloors());
    }// endregion hashCode() and equals()

    // region toString() -- generated by BoB the Builder of Beans
    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}")
                .add("id=" + getId())
                .add("floors=" + getFloors())
                .toString();
    }// endregion toString()
    // endregion Constructor, getters, setters, equals, hashCode, toString
}
