/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package optimumpathfinder;

import javax.swing.JFrame;

/**
 *
 * @author Areeba Tariq
 */
public class OptimumPathFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame window=new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(new DemoPanel());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
}
