package org.github.jamiebuckley

import org.github.jamiebuckley.state.GameState
import org.github.jamiebuckley.state.builders.GameStateCreator

class FeudalGame(gameStateBuilder: GameStateCreator) {
    val state: GameState = gameStateBuilder.getGameState()
}