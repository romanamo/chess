package de.romanamo.chess.model.field;

import de.romanamo.chess.model.move.Move;
import de.romanamo.chess.model.move.MoveNotApplicableException;
import de.romanamo.chess.model.piece.Piece;
import de.romanamo.chess.model.square.Square;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Field<
        F extends Field<F,K,M,P,S>,
        K,
        M extends Move<F,K,M,P,S>,
        P extends Piece<F,K,M,P,S>,
        S extends Square<? extends P>> {

    S getValue(K id);

    P getPiece(K id);

    Set<K> getIdentifiers();

    Set<S> getValues();



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

    default boolean containsValue(S val) {
        return this.getValues().contains(val);
    }

    List<P> getFigures();

    Map<K, P> getKeyFigureMap();

    void setFigure(K id, P figure);

    default void doMove(M move) throws MoveNotApplicableException {
        move.doMove((F) this);
    }

    default void undoMove(M move) throws MoveNotApplicableException {
        move.undoMove((F) this);
    }
}
