/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Carlton
 */
public class main extends JApplet implements ActionListener {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    Button bt1,bt2,bt3;
    int type = -1;
    public void init() {
        // TODO start asynchronous download of heavy resources
        setLayout(null);
        bt1 = new Button("Line");
        bt2 = new Button("Rectangle");
        bt3 = new Button("Oval");
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt1.setBounds(10, 20, 100, 50);
        bt2.setBounds(120, 20, 100, 50);
        bt3.setBounds(230, 20, 100, 50);
        add(bt1);
        add(bt2);
        add(bt3);
    // TODO overwrite start(), stop() and destroy() methods
}

    @Override
    public void actionPerformed(ActionEvent e) {
        Button ref;
        ref = (Button)e.getSource();
        
        if(ref==bt1){
            type=1;
        }else if(ref == bt2){
            type = 2;
        }else{
         type = 3;
        }
        repaint();
    }
}
