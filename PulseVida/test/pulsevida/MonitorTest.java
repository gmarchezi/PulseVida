/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsevida;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MARCHEZI
 */
public class MonitorTest {
    
    public MonitorTest() {
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
     * Test of disparaNotificacao method, of class Monitor.
     */
    @Test
    public void testDisparaNotificacao() {
        System.out.println("disparaNotificacao");
        int freq = 0;
        String nomePessoa = "";
        String celular = "";
        Monitor instance = new Monitor();
        instance.disparaNotificacao(freq, nomePessoa, celular);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of monitoraFrequencia method, of class Monitor.
     */
    @Test
    public void testMonitoraFrequencia() {
        System.out.println("monitoraFrequencia");
        int freq = 0;
        Pessoa pessoa = null;
        Monitor instance = new Monitor();
        instance.monitoraFrequencia(freq, pessoa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of simularFrequencia method, of class Monitor.
     */
    @Test
    public void testSimularFrequencia() {
        System.out.println("simularFrequencia");
        Monitor instance = new Monitor();
        instance.simularFrequencia();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
