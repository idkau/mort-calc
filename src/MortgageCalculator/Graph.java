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

public class Graph extends MortgageClient {
    
   
  public void paintComponent(Graphics g){
       
        
        g.drawOval((int)getMonthlyInterestRate(), 120, 2, 2 );
    }
    
  
}
