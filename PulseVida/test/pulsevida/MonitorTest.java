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
     * Test of Disparanotificacao method, of class Monitor.
     */
    @Test
    public void testDisparanotificacao() {
        Monitor instance = new Monitor();
        instance.disparaNotificacao(150,"Gabriel", "Guiga","997483568");
        assertEquals("Gabriel",notificacao.getNomeUsuario());
        //Verificar se foi criada a notificacao corretamente, n sei fazer isso kkkk
        //fail("Leia o comentário no teste!");
    }
}
