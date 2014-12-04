package main;

import PhotoAppPanel.PhotoAppPanel;
import javax.swing.JApplet;
import javax.swing.JPanel;

/**
 *
 * @author Niall
 */
public class main extends JApplet
{
    public void init()
    {
        JPanel panel = new PhotoAppPanel();
        this.add(panel);
    }
}
