package de.romanamo.chess.model.field;

import de.romanamo.chess.model.piece.Piece;
import de.romanamo.chess.model.square.Square;

import java.util.List;
import java.util.Set;

public interface Field<K, V extends Square<P>, P extends Piece> {

    V getValue(K id);

    Set<K> getIdentifiers();

    Set<V> getValues();

    /**
     * Creates a {@link String Representation} of the implemented Field
     * corresponding to its usual way of representation.
     *
     * @param showIdentifiers specifies, if any kind of indication
     *                        towards the {@link K Identifier} is supposed to be made
     * @return {@link String Representation} of the Field
     */
    String toString(boolean showIdentifiers);

    default boolean containsIdentifier(K id) {
        return this.getIdentifiers().contains(id);
    }

    default boolean containsValue(V val) {
        return this.getValues().contains(val);
    }

    List<P> getFigures();


}
