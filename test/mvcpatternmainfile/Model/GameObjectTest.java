/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpatternmainfile.Model;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mahir
 */
public class GameObjectTest {
    GameObject instance;
    public GameObjectTest() {
    }
    
    @Before
    public void setUp() {
        instance = new GameObject(new Circle());
       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class GameObject.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        instance.velocity = new Point2D(1.0,2.0);
        instance.update();
        assertEquals(instance.view.getTranslateX(),1.0,0.0);
        assertEquals(instance.view.getTranslateY(),2.0,0.0);
    }

    /**
     * Test of setVelocity method, of class GameObject.
     */
    @Test
    public void testSetVelocity() {
        System.out.println("setVelocity");
        Point2D velocity = new Point2D(0.0,0.0);
        instance.setVelocity(velocity);
        assertEquals(velocity,instance.velocity);
    }

    /**
     * Test of setAcceleration method, of class GameObject.
     */
    @Test
    public void testSetAcceleration() {
        System.out.println("setAcceleration");
        double accx = 2.0;
        double accy = 3.0;
        instance.setAcceleration(accx, accy);
        assertEquals(instance.accx,accx,0.0);
        assertEquals(instance.accy,accy,0.0);
    }

    /**
     * Test of getVelocity method, of class GameObject.
     */
    @Test
    public void testGetVelocity() {
        System.out.println("getVelocity");
        Point2D expResult = instance.velocity;
        Point2D result = instance.getVelocity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getView method, of class GameObject.
     */
    @Test
    public void testGetView() {
        System.out.println("getView");
        Node expResult = instance.view;
        Node result = instance.getView();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAlive method, of class GameObject.
     */
    @Test
    public void testIsAlive() {
        System.out.println("isAlive");
        boolean expResult = instance.alive;
        boolean result = instance.isAlive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isDead method, of class GameObject.
     */
    @Test
    public void testIsDead() {
        System.out.println("isDead");
        boolean expResult = !instance.alive;
        boolean result = instance.isDead();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAlive method, of class GameObject.
     */
    @Test
    public void testSetAlive() {
        System.out.println("setAlive");
        boolean alive = false;
        instance.setAlive(alive);
        assertEquals(alive,instance.alive);
    }

    /**
     * Test of rotateRight method, of class GameObject.
     */
    @Test
    public void testRotateRight() {
        System.out.println("rotateRight");
        double expres = instance.view.getRotate()+20;
        instance.rotateRight();
        assertEquals(instance.view.getRotate(),expres,0.0);
    }

    /**
     * Test of rotateLeft method, of class GameObject.
     */
    @Test
    public void testRotateLeft() {
        System.out.println("rotateLeft");
    double expres = instance.view.getRotate()-20;
        instance.rotateLeft();
        assertEquals(instance.view.getRotate(),expres,0.0);
    }
}
