package org.github.jamiebuckley.state

import org.github.jamiebuckley.data.Terrain

interface GameState {
    val mode: GameMode
    val terrain: Terrain
}