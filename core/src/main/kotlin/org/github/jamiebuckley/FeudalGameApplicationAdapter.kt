package org.github.jamiebuckley

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.PerspectiveCamera
import com.badlogic.gdx.graphics.VertexAttributes
import com.badlogic.gdx.graphics.g3d.Environment
import com.badlogic.gdx.graphics.g3d.Material
import com.badlogic.gdx.graphics.g3d.Model
import com.badlogic.gdx.graphics.g3d.ModelBatch
import com.badlogic.gdx.graphics.g3d.ModelInstance
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController

class FeudalGameApplicationAdapter : ApplicationAdapter() {

	private lateinit var cam: PerspectiveCamera
	private lateinit var camController: CameraInputController
	private lateinit var model: Model
	private lateinit var instance: ModelInstance
	private lateinit var modelBatch: ModelBatch
	private lateinit var environment: Environment

	override fun create () {
		modelBatch = ModelBatch()
		cam = PerspectiveCamera(67f, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
		cam.position.set(10f, 10f, 10f)
		cam.lookAt(0f, 0f, 0f)
		cam.near = 1f
		cam.far = 300f
		cam.update()
		camController = CameraInputController(cam)
		Gdx.input.inputProcessor = camController

		val modelBuilder = ModelBuilder()
		model = modelBuilder.createBox(5f, 5f, 5f,
				Material(ColorAttribute.createDiffuse(Color.GREEN)),
				(VertexAttributes.Usage.Position or VertexAttributes.Usage.Normal).toLong())
		instance = ModelInstance(model)

		environment = Environment()
		environment.set(ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f))
		environment.add(DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f))
	}

	override fun render () {
		Gdx.gl.glViewport(0, 0, Gdx.graphics.width, Gdx.graphics.height)
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)

		modelBatch.begin(cam)
		modelBatch.render(instance, environment)
		modelBatch.end()
	}

	override fun dispose () {
		modelBatch.dispose()
		model.dispose()
	}
}
