package org.coding.common.error;

import org.coding.common.annotation.Nullable;

import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

public class Error {
    private String field;
    @Nullable
    private String errorMessage;

    // region Constructor, getters, setters, equals, hashCode, toString -- generated by BoB the Builder of Beans
    // The code below has been generated by BoB the Builder of Beans based on the class' fields.
    // Everything after this comment will be regenerated if you invoke BoB again.
    // If you don't know who BoB is, you can find him here: https://bitbucket.org/atlassianlabs/bob-the-builder-of-beans

    public Error(String field, @Nullable String errorMessage) {
        this.field = Objects.requireNonNull(field);
        this.errorMessage = errorMessage;
    }

    // region Getters and setters -- generated by BoB the Builder of Beans
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = Objects.requireNonNull(field);
    }

    public Optional<String> getErrorMessage() {
        return Optional.ofNullable(errorMessage);
    }

    public void setErrorMessage(@Nullable String errorMessage) {
        this.errorMessage = errorMessage;
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

        Error that = (Error) o;

        return Objects.equals(this.getField(), that.getField()) && Objects.equals(this.getErrorMessage(), that.getErrorMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getField(), getErrorMessage());
    }// endregion hashCode() and equals()

    // region toString() -- generated by BoB the Builder of Beans
    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}")
                .add("field=" + getField())
                .add("errorMessage=" + getErrorMessage())
                .toString();
    }// endregion toString()
    // endregion Constructor, getters, setters, equals, hashCode, toString
}
