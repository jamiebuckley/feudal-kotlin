package org.github.jamiebuckley.state.builders

import org.github.jamiebuckley.data.Terrain
import org.github.jamiebuckley.state.GameMode
import org.github.jamiebuckley.state.GameState

class NewGameStateCreator : GameStateCreator {
    override fun getGameState(): GameState {
        return object: GameState {
            override val mode: GameMode = GameMode.RUNNING
            override val terrain = generateTerrain()
        }
    }

    private fun generateTerrain(): Terrain {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}