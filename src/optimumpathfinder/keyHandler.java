/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package optimumpathfinder;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Areeba Tariq
 */
public class keyHandler implements KeyListener {

    DemoPanel dp;
    public keyHandler (DemoPanel dp)
    {
        this.dp=dp;
    }
    @Override
    public void keyTyped(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_ENTER)
        {
            dp.autoSearch();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
