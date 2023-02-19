package de.romanamo.chess.model.game;

import de.romanamo.chess.model.player.Player;

import java.util.Set;

public interface Game {

    void register(Player player);

    default void register(Set<? extends Player> players) {
        players.forEach(this::register);
    }

    Set<? extends Player> getRegisteredPlayers();

    boolean isFinished();

}
