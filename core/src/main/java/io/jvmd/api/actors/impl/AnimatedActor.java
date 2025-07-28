package io.jvmd.api.actors.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import io.jvmd.api.world.BPBWorld;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimatedActor extends SimpleActor {


    private Map<String, Animation<TextureRegion>> animations;
    private Map<String, Texture> sheetsSource;
    private float stateTime;
    private boolean isAnimating;
    private TextureRegion currenetFrame;


    public AnimatedActor(BodyDef.BodyType bodyType, Vector2 position, Vector2 proportion, BPBWorld world, Map<String, String> sheets, int cols, int rows, float frameDuration) {
        super(bodyType, position, proportion, world);
        sheetsSource = new HashMap<>();
        animations = new HashMap<>();
        sheets.forEach((name, sheetPath) -> {
            Texture texture = new Texture(sheetPath);
            sheetsSource.put(name, texture);
            TextureRegion[][] region = TextureRegion.split(sheetsSource.get(name), texture.getWidth() / cols, texture.getHeight() / rows);
            TextureRegion[] regions = new TextureRegion[cols * rows];
            int index = 0;
            for (int a = 0; a < rows; a++) {
                for (int j = 0; j < cols; j++) {
                    regions[index++] = region[a][j];
                }
            }

            animations.put(name, new Animation<>(frameDuration, regions));
            stateTime = 0;
        });
    }

    @Override
    public void render(Batch batch) {
        if (!isAnimating) {
            super.render(batch);
        }
    }

    boolean isFlipping = false;

    public void playAnimation(String animationName, boolean flipX, boolean flipY, boolean looping) {
        if (stateTime == -1) currenetFrame = new TextureRegion(getTexture());
        else {
            isAnimating = true;
        }
        stateTime += Gdx.graphics.getDeltaTime();
        currenetFrame = animations.get(animationName).getKeyFrame(stateTime, looping);
        currenetFrame.flip(flipX, flipY);
        batch.begin();
        batch.draw(currenetFrame, getPosition().x, getPosition().y);
        batch.end();
    }

    public void stopAnimation() {
        stateTime = -1;
        isAnimating = false;
    }


    @Override
    public void dispose() {
        super.dispose();
        sheetsSource.values().forEach(Texture::dispose);
    }

}
