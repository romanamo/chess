package de.romanamo.chess.model.field;

import java.util.Set;

public interface Field<Identifier, Value> {

    Value getValue(Identifier id);

    Set<Identifier> getIdentifiers();

    Set<Value> getValues();

    /**
     * Creates a {@link String Representation} of the implemented Field
     * corresponding to its usual way of representation.
     *
     * @param showIdentifiers specifies, if any kind of indication
     *                        towards the {@link Identifier Identifier} is supposed to be made
     * @return {@link String Representation} of the Field
     */
    String toString(boolean showIdentifiers);

    default boolean containsIdentifier(Identifier id) {
        return this.getIdentifiers().contains(id);
    }

    default boolean containsValue(Value val) {
        return this.getValues().contains(val);
    }


}
