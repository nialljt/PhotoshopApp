package PhotoAppPanel;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.*;


/**
 *
 * @author Niall & Anthony
 */
public class PhotoApp extends JApplet 
{
    
    @Override
    public void init()
    {
 
        PhotoAppPanel photoAppPanel = new PhotoAppPanel();
        this.add(photoAppPanel);
        this.setVisible(true);

    }
}

    

  


