package de.romanamo.chess.model.move;

import de.romanamo.chess.model.field.Field;
import de.romanamo.chess.model.piece.Piece;
import de.romanamo.chess.model.square.Square;

/**
 * Interface to describe any kind move that can be made on {@link Field}.
 * <p>
 * The Move interface provides Methods to execute and revert Move,
 * changing the state of the Field.
 * <p>
 * If any kind of Move can not be executed a {@link MoveNotApplicableException}
 * is thrown, to indicate that this special move is unable to be applied
 * within the current State of the Field.
 *
 * @param <P> Piece
 * @param <F> Field
 */
public interface Move<
        F extends Field<F,K,M,P,S>,
        K,
        M extends Move<F,K,M,P,S>,
        P extends Piece<F,K,M,P,S>,
        S extends Square<? extends P>>{

    /**
     * Applies the {@link Move} onto the given {@link Field}
     *
     * @param field onto which the Move is supposed to be applied
     * @throws MoveNotApplicableException if the Move cannot be applied onto the given Field
     */
    void doMove(F field) throws MoveNotApplicableException;

    /**
     * Reverts the {@link Move} onto the given {@link Field}
     *
     * @param field onto which the Move is supposed to be reverted
     * @throws MoveNotApplicableException if the Move cannot be reverted onto the given Field
     */
    void undoMove(F field) throws MoveNotApplicableException;
}
