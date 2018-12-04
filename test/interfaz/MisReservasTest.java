/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MisReservasTest {

    public MisReservasTest() {
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
    public void ReservasUser1() {
        String usuario = "jose";
        DatabaseAccess instance = new DatabaseAccess();
        assertEquals(1, instance.obtenerMisReservas(usuario).size());
    }

    @Test
    public void ReservasUser2() {
        String usuario = "mario";
        DatabaseAccess instance = new DatabaseAccess();
        assertEquals(0, instance.obtenerMisReservas(usuario).size());
    }

    @Test
    public void SegundaReserva() {
        String usuario = "javierzudaire";
        DatabaseAccess instance = new DatabaseAccess();
        ArrayList list = instance.obtenerMisReservas(usuario);
        assertEquals(" Hora: 6:50 | De: Calle Juan Calvo | A: Universidad CEU San Pablo", list.get(1));
    }

}
