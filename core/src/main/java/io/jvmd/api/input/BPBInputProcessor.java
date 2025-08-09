package io.jvmd.api.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class BPBInputProcessor extends InputAdapter {

    private Vector2 direction = new Vector2();

    private boolean isMoveLeft;
    private boolean isMoveRight;
    private boolean isMoveUp;
    private boolean isMoveDown;


    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.W)   isMoveUp = true;
        if (keycode == Input.Keys.S)   isMoveDown = true;
        if (keycode == Input.Keys.A)   isMoveLeft = true;
        if (keycode == Input.Keys.D)   isMoveRight = true;

        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.W)   isMoveUp = false;
        if (keycode == Input.Keys.S)   isMoveDown = false;
        if (keycode == Input.Keys.A)   isMoveLeft = false;
        if (keycode == Input.Keys.D)   isMoveRight = false;

        return super.keyUp(keycode);
    }

    public Vector2 getDirection() {
            direction.set(0, 0);

            if (isMoveLeft) direction.add(-1 , 0);
            if (isMoveRight) direction.add(1 , 0);
            if (isMoveDown) direction.add(0, -1);
            if (isMoveUp) direction.add(0 , 1);

            return direction;
    }

}
