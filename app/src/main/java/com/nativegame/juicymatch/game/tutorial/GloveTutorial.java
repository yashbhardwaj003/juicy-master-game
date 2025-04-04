package com.nativegame.juicymatch.game.tutorial;

import com.nativegame.juicymatch.R;
import com.nativegame.juicymatch.asset.Textures;
import com.nativegame.juicymatch.game.GameWorld;
import com.nativegame.juicymatch.game.effect.tutorial.TutorialFingerEffect;
import com.nativegame.juicymatch.game.effect.tutorial.TutorialHintEffectSystem;
import com.nativegame.juicymatch.level.Level;
import com.nativegame.natyengine.engine.Engine;
import com.nativegame.natyengine.ui.GameActivity;
import com.nativegame.natyengine.ui.GameButton;

/**
 * Created by Oscar Liang on 2022/02/23
 */

public class GloveTutorial implements Tutorial {

    private final TutorialHintEffectSystem mHintEffect;
    private final TutorialFingerEffect mFingerEffect;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public GloveTutorial(Engine engine) {
        mHintEffect = new TutorialHintEffectSystem(engine);
        mFingerEffect = new TutorialFingerEffect(engine, Textures.TUTORIAL_FINGER);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void show(GameActivity activity) {
        mHintEffect.activate(Level.LEVEL_DATA.getTutorialHint().toCharArray());
        int marginX = (GameWorld.WORLD_WIDTH - Level.LEVEL_DATA.getColumn() * 300) / 2;
        int marginY = (GameWorld.WORLD_HEIGHT - Level.LEVEL_DATA.getRow() * 300) / 2;
        mFingerEffect.activate(marginX + 1200, marginX + 1200, marginY + 100, marginY + 400);

        // Click the booster button
        GameButton btnGlove = (GameButton) activity.findViewById(R.id.btn_glove);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btnGlove.performClick();
            }
        });
    }
    //========================================================

}
