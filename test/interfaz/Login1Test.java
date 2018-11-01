/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Login1Test {
    
    public Login1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testNoUsuarioNoContra() throws Exception {
        String username = "";
        String password = "";
        boolean expResult = false;
        boolean result = Login1.authenticate(username, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUsuarioCorrecto() throws Exception {
        String username = "javierzudaire";
        String password = "secret";
        boolean expResult = true;
        boolean result = Login1.authenticate(username, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUsuarioCorrectoContraNo() throws Exception {
        String username = "javierzudaire";
        String password = "aoijoadjd";
        boolean expResult = false;
        boolean result = Login1.authenticate(username, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUsuarioIncorrectoContraExiste() throws Exception {
        String username = "oadjoijad";
        String password = "secret";
        boolean expResult = false;
        boolean result = Login1.authenticate(username, password);
        assertEquals(expResult, result);
    }
    
}
