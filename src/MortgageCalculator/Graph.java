/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MortgageCalculator;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author jason
 */

public class Graph extends JPanel {
    
   
    public Graph(){
        
    }
    
    
    @Override
  public void paintComponent(Graphics g){
       
        super.paintComponent(g);
        
        g.drawOval(12, 120, 5, 5 );
    }
    
  
}
