/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jose
 */
public class DatabaseAccessTest {
    
    public DatabaseAccessTest() {
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

    

    /**
     * Test of comprobarUsuario method, of class DatabaseAccess.
     */
    @Test
    public void testComprobarUsuario() throws Exception {
       
        String user = "jose";
        DatabaseAccess instance = new DatabaseAccess();
        int expResult = 1;
        int result = instance.comprobarUsuario(user);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of obtenerContraseña method, of class DatabaseAccess.
     */
    @Test
    public void testObtenerContraseña() throws Exception {
       
        String user = "jose";
        DatabaseAccess instance = new DatabaseAccess();
        String expResult = "jose";
        String result = instance.obtenerContraseña(user);
        assertEquals(expResult, result);
        
            }

    /**
     * Test of obtenerViajes method, of class DatabaseAccess.
     */
   /* @Test
    public void testObtenerViajes() {
        
        DatabaseAccess instance = new DatabaseAccess();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerViajes();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of obtenerPerfil method, of class DatabaseAccess.
     */
    @Test
    public void testObtenerPerfil() {
        System.out.println("obtenerPerfil");
        String usuario = "jose";
        DatabaseAccess instance = new DatabaseAccess();
        String expResult = "jose";
        ArrayList result = instance.obtenerPerfil(usuario);
        assertTrue( result.contains(expResult));
       
    }
    
    @Test
    public void testObtenerPerfilFalso() {
        System.out.println("obtenerPerfil");
        String usuario = "jose";
        DatabaseAccess instance = new DatabaseAccess();
        String expResult = "Javier";
        ArrayList result = instance.obtenerPerfil(usuario);
        assertFalse( result.contains(expResult));
       
    }
    

    /**
     * Test of addViaje method, of class DatabaseAccess.
     */
    //@Test
    /*public void testAddViaje() throws Exception {
        
        String start = "";
        String end = "Europea";
        String hora = "8:00AM";
        DatabaseAccess instance = new DatabaseAccess();
        instance.addViaje(start, end, hora);
    }
    */
}
