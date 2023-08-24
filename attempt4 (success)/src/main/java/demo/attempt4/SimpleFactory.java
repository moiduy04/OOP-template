package demo.attempt4;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGL.entityBuilder;

public class SimpleFactory implements EntityFactory {
    @Spawns("enemy")
    public Entity newEnemy(SpawnData data){
//  public Entity  ______ (SpawnData data) <---- syntax:
//      *NOTE: aside from the method name, the other parts has to be the same.

        return FXGL.entityBuilder(data)
//                .view(new Rectangle(40,40, Color.RED))
                .view("balloom.png")
                .with(new ProjectileComponent(new Point2D(1,0), 100))
//                 .with() adds a component (a 'property') to the Entity.
//                 Point2D(x,y) creates a 'vector' with coordinates (x,y).
//                 speed ('150' in this case) is in (pixels per second).
                .build();
//      or         .buildAndAttach();
//               Build  = create the entity
//               Attach = add it to the game world


//      *NOTE: Do this if you don't know what you can use in FXGL:
//                  FXGL.   <--- This will open a menu that shows what you can use
    }

    @Spawns("ally")
    public Entity newAlly(SpawnData data){
        var texture = FXGL.texture("brick.png");

        return FXGL.entityBuilder(data)
                .view(texture)
                .with(new ProjectileComponent(new Point2D(-1,0), 150))
                .build();
    }
}
