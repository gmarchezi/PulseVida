/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author MARCHEZI
 */
public class MonitorTest {
    /**
     * Test of Disparanotificacao method, of class Monitor.
     */
    @Test
    public void testDisparanotificacao() {
        Monitor instance = new Monitor();
        try {
            gerouNotificacao = instance.disparaNotificacao(-9, "Gabriel", "Guiga", "997483568");
            
        } catch (Exception ex) {
            ex.printStackTrace();           
            return;
        }
        
    }
}
