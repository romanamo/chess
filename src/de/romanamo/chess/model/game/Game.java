package de.romanamo.chess.model.game;

import de.romanamo.chess.model.field.Field;
import de.romanamo.chess.model.move.Move;
import de.romanamo.chess.model.piece.Piece;
import de.romanamo.chess.model.player.Player;
import de.romanamo.chess.model.square.Square;

import java.util.Set;

public interface Game<F extends Field<F,K,M,P,S>,
        K,
        M extends Move<F,K,M,P,S>,
        P extends Piece<F,K,M,P,S>,
        S extends Square<? extends P>,
        J extends Player<F,K,M,P,S>> {

    void register(J player);

    default void register(Set<J> players) {
        players.forEach(this::register);
    }

    Set<J> getRegisteredPlayers();

    boolean isFinished();

}
