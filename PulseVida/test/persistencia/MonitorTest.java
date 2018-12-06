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
        boolean gerouNotificacao;
        boolean gerouNotificacao1;
        boolean gerouNotificacao2;
        try {
            gerouNotificacao = instance.disparaNotificacao(-9, "Gabriel", "Guiga", "997483568");
            gerouNotificacao1 = instance.disparaNotificacao(60, "Gabriel", "Guiga", "997483568");
            gerouNotificacao2 = instance.disparaNotificacao(300, "Gabriel", "Guiga", "997483568");
            
        } catch (Exception ex) {
            //ex.printStackTrace();
            return;
        }
        assertTrue("Teste menor que zero",gerouNotificacao==false);
        assertTrue("Teste correto",gerouNotificacao1==true);
        assertTrue("Teste maior que duzentos",gerouNotificacao2==false);
        
    }
}
