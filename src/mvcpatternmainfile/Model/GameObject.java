package mvcpatternmainfile.Model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahir
 */
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.shape.Shape;

public class GameObject{       
    private Node view;
    private Point2D velocity = new Point2D(0, 0);
    private boolean alive = true;
    public double accx;
    public double accy;

    public GameObject(Node view) {
        this.view = view;
    }

    public void update() {
        velocity = velocity.add(accx,accy);
        view.setTranslateX(view.getTranslateX() + velocity.getX());
        view.setTranslateY(view.getTranslateY() + velocity.getY());
    }

    public void setVelocity(Point2D velocity) {
        this.velocity = velocity;
    }
    
    public void setAcceleration(double accx, double accy){
        this.accx=accx;
        this.accy=accy;
    }

    public Point2D getVelocity() {
        return velocity;
    }

    public Node getView() {
        return view;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isDead() {
        return !alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public double getRotate() {
        return view.getRotate();
    }

    public void rotateRight() {
        view.setRotate(view.getRotate() + 20);
    }

    public void rotateLeft() {
        view.setRotate(view.getRotate() - 20);
}

    public boolean isColliding(GameObject other) {
        Shape intx = Shape.intersect((Shape)this.getView(), (Shape)other.getView());
        return intx.getBoundsInLocal().getWidth() != -1;
    }
}
    
