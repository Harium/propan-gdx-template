package com.myproject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.math.Vector3;
import com.harium.propan.core.context.ApplicationGL;
import com.harium.propan.core.graphics.Graphics3D;
import com.harium.propan.core.loader.MeshLoader;

public class HelloPropanGDX extends ApplicationGL {

    ModelBatch modelBatch;
    Environment environment;

    Model model;
    ModelInstance instance;

    // Rotation Speed
    float speed = 0.2f;

    public HelloPropanGDX(int w, int h) {
        super(w, h);
    }

    public void init(Graphics3D g) {
        modelBatch = new ModelBatch();
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        camera = new PerspectiveCamera(67, w, h);
        camera.position.set(10, 5, 0);
        camera.lookAt(0, 0, 0);
        camera.near = 0.1f;
        camera.far = 300f;
        camera.update();

        model = MeshLoader.getInstance().loadModel("house/house.obj");
        instance = new ModelInstance(model);
        instance.transform.scl(1.5f);
    }

    public void display(Graphics3D graphics3D) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(1, 1, 1, 1f);

        modelBatch.begin(camera);
        modelBatch.render(instance, environment);
        modelBatch.end();

        // Rotate the model
        instance.transform.rotate(Vector3.Y, speed);
    }

    public void dispose() {
        model.dispose();
        modelBatch.dispose();
    }

}
