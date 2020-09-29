/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcpatternmainfile.Model;

import javafx.scene.control.Label;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mahir
 */
public class DBmodelTest {
    DBmodel instance;
    public DBmodelTest() {
    }
    
    @Before
    public void setUp() {
        instance = new DBmodel();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validcheck method, of class DBmodel.
     */
    @Test
    public void testValidcheck() {
        System.out.println("validcheck");
        String x1 = "AA11111";
        String x2 = "aa1111";
        boolean expResult1 = true;
        boolean expResult2 = false;
        boolean result1 = instance.validcheck(x1);
        boolean result2 = instance.validcheck(x2);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
    }

    @Test
    public void testSignupmethod() {
        System.out.println("signupmethod");
        String p = "Aa111111";
        String cp = "Aa111111";
        int expResult = 3;
        int result = instance.signupmethod(p, cp);
        assertEquals(expResult, result);
    }
}
