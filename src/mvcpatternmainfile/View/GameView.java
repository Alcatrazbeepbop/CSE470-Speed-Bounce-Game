package mvcpatternmainfile.View;
import mvcpatternmainfile.View.UIVIew;
import mvcpatternmainfile.Model.GameObject;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahir
 */
public class GameView {
    public AnimationTimer timer;
    public GameObject player;
    public GameObject ally;
    public GameObject enemy;
    private Pane root;
    public Parent createContent() {
        root = new Pane();
        root.setPrefSize(620, 620);
        player = new Player();
        ally = new Ally();
        enemy = new Enemy();
        player.setVelocity(new Point2D(0, 0));
        player.setAcceleration(.05,.05);
        addGameObject(player, 300, 300);
        addGameObject(ally, 0, 0);
        addGameObject(enemy, 580, 480);
        return root;
    }
    private void addGameObject(GameObject object, double x, double y) {
        object.getView().setTranslateX(x);
        object.getView().setTranslateY(y);
        root.getChildren().add(object.getView());
    }

    public void onUpdate(UIVIew ui,Stage pstage) {
                Circle temp = (Circle)player.getView();
                if (player.isColliding(enemy) || temp.getTranslateX() <= (root.getBoundsInLocal().getMinX()+temp.getRadius())|| temp.getTranslateX() >= (root.getBoundsInLocal().getMaxX()-temp.getRadius())|| temp.getTranslateY() <= (root.getBoundsInLocal().getMinY()+temp.getRadius())|| temp.getTranslateY() >= (root.getBoundsInLocal().getMaxY()-temp.getRadius())) {
                    enemy.setAlive(false);
                    player.setAlive(false);
                    ally.setAlive(false);
                    root.getChildren().removeAll(enemy.getView(), player.getView(),ally.getView());
                    timer.stop();
                    pstage.setScene(ui.pscene);
                }
                else if(player.isColliding(ally)){
                    double speedx=-player.getVelocity().getX();
                    double speedy=-player.getVelocity().getX();
                    player.setVelocity(new Point2D(speedx,speedy));
                    player.setAcceleration(-player.accx, -player.accy);
                }
                  player.update(); 
}
    private static class Enemy extends GameObject {
        Enemy() {
            super(new Rectangle(40, 20, Color.RED));
        }
    }

    private static class Player extends GameObject {
        Player() {
            super(new Circle(15, Color.BLUE));
        }
    }
    private static class Ally extends GameObject {
        
        Ally() {
            super(new Rectangle(40, 20, Color.YELLOW));
        }

    }
    
}
