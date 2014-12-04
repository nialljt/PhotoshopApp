package PhotoAppPanel;

import ImageObject.ImageObj;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

/**
 *
 * @author Niall
 */
public class PhotoAppPanel extends JPanel implements ActionListener{
    
    private JButton mOpenButton = new JButton("Open");
    private JFileChooser mFileChooser = new JFileChooser();
    private Canvas mCanvas = new Canvas();
    private Vector<ImageObj> imgVector = new Vector<ImageObj>();
    
    public PhotoAppPanel(){
        
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
