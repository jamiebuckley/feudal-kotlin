package org.github.jamiebuckley.state.builders

import org.github.jamiebuckley.state.GameState

interface GameStateCreator {
    fun getGameState(): GameState;
}