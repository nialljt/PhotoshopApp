package PhotoAppPanel;

import java.awt.*;
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
        this.setBackground(Color.yellow);
        PhotoAppPanel photoAppPanel = new PhotoAppPanel();
        this.add(photoAppPanel);
        this.setVisible(true);
    }
}