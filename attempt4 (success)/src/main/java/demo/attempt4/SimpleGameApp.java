package demo.attempt4;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Rectangle2D;
import javafx.util.Duration;

public class SimpleGameApp extends GameApplication {

    @Override
    protected void initSettings(GameSettings gameSettings) {

    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new SimpleFactory());
//        Telling FXGL what Factory you're using to create Entities.

//        FXGL.spawn("enemy", 100, 100);
//        Spawns "enemy" entity at (x,y) = (100, 100) (in pixels)
//  *NOTE: The entity name needs to be exactly the same as defined.

        FXGL.run(() -> {
            FXGL.spawn("enemy", FXGLMath.randomPoint(
                    new Rectangle2D(0,0, FXGL.getAppWidth(), FXGL.getAppHeight()))
            );
            FXGL.spawn("ally", FXGLMath.randomPoint(
                    new Rectangle2D(0,0, FXGL.getAppWidth(), FXGL.getAppHeight()))
            );
        }, Duration.seconds(0.75));

    }

    public static void main(String[] args){
        launch(args);
    }
}
