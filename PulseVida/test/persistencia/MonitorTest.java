/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.logging.Level;
import java.util.logging.Logger;
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
    
   
    /**
     * Test of Disparanotificacao method, of class Monitor.
     */
    @Test
    public void testDisparanotificacao() {
        Monitor instance = new Monitor();
        boolean gerouNotificacao;
        try {
            gerouNotificacao = instance.disparaNotificacao(-9, "Gabriel", "Guiga", "997483568");
        } catch (Exception ex) {
            //ex.printStackTrace();
            return;
        }
        
        fail("Erro no teste.");
        //assertEquals(true ,gerouNotificacao);
    }
}
