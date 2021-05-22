package org.coding.parkinglot.domain;

import java.util.Objects;
import java.util.StringJoiner;

public class Vehicle {
    private String registration;
    private String type;

    // region Constructor, getters, setters, equals, hashCode, toString -- generated by BoB the Builder of Beans
    // The code below has been generated by BoB the Builder of Beans based on the class' fields.
    // Everything after this comment will be regenerated if you invoke BoB again.
    // If you don't know who BoB is, you can find him here: https://bitbucket.org/atlassianlabs/bob-the-builder-of-beans

    public Vehicle(String registration, String type) {
        this.registration = Objects.requireNonNull(registration);
        this.type = Objects.requireNonNull(type);
    }

    // region Getters and setters -- generated by BoB the Builder of Beans
    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = Objects.requireNonNull(registration);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = Objects.requireNonNull(type);
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

        Vehicle that = (Vehicle) o;

        return Objects.equals(this.getRegistration(), that.getRegistration()) && Objects.equals(this.getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegistration(), getType());
    }// endregion hashCode() and equals()

    // region toString() -- generated by BoB the Builder of Beans
    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}")
                .add("registration=" + getRegistration())
                .add("type=" + getType())
                .toString();
    }// endregion toString()
    // endregion Constructor, getters, setters, equals, hashCode, toString
}