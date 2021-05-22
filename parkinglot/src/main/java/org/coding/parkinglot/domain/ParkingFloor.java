package org.coding.parkinglot.domain;

import org.coding.common.annotation.Nullable;

import java.util.*;

public class ParkingFloor {
    @Nullable
    private Integer id;
    private ParkingLot lot;
    private List<Slot> slots;

    // region Constructor, getters, setters, equals, hashCode, toString -- generated by BoB the Builder of Beans
    // The code below has been generated by BoB the Builder of Beans based on the class' fields.
    // Everything after this comment will be regenerated if you invoke BoB again.
    // If you don't know who BoB is, you can find him here: https://bitbucket.org/atlassianlabs/bob-the-builder-of-beans

    public ParkingFloor(@Nullable Integer id, ParkingLot lot, Collection<Slot> slots) {
        this.id = id;
        this.lot = Objects.requireNonNull(lot);
        this.slots = new ArrayList<>(Objects.requireNonNull(slots));
    }

    // region Getters and setters -- generated by BoB the Builder of Beans
    public Optional<Integer> getId() {
        return Optional.ofNullable(id);
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    public ParkingLot getLot() {
        return lot;
    }

    public void setLot(ParkingLot lot) {
        this.lot = Objects.requireNonNull(lot);
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = new ArrayList<>(Objects.requireNonNull(slots));
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

        ParkingFloor that = (ParkingFloor) o;

        return Objects.equals(this.getId(), that.getId()) && Objects.equals(this.getLot(), that.getLot()) && Objects.equals(this.getSlots(), that.getSlots());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLot(), getSlots());
    }// endregion hashCode() and equals()

    // region toString() -- generated by BoB the Builder of Beans
    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}")
                .add("id=" + getId())
//                .add("lot=" + getLot())
                .add("slots=" + getSlots())
                .toString();
    }// endregion toString()
    // endregion Constructor, getters, setters, equals, hashCode, toString
}
