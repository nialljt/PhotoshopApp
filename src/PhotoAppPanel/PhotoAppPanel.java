/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PhotoAppPanel;

import ImageObject.ImageObj;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Anthony
 */
public class PhotoAppPanel extends JPanel implements ActionListener
{
    private JMenuBar menuBar = new JMenuBar();
    private ImageIcon addImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/Add_icon.png"));
    private ImageIcon saveImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/Add_icon.png"));
    private JMenu file = new JMenu("File");
    private JMenuItem fileAdd = new JMenuItem("Add", addImageIcon);
    private JMenuItem fileSave = new JMenuItem("Save", saveImageIcon);
    private JFileChooser mFileChooser = new JFileChooser();
    private CanvasObj mCanvas = new CanvasObj();
    private Vector<ImageObj> imgVector = new Vector<ImageObj>();
    private JPanel mButtonPanel = new JPanel(), mImagePanel = new JPanel();

    public PhotoAppPanel()
    {
        super();

        this.setBackground(Color.BLUE);

        fileAdd.addActionListener(this);
        fileSave.addActionListener(this);
        fileAdd.setToolTipText("Add a new image to the collage");
        fileSave.setToolTipText("Save a file to your drive");

        this.mFileChooser.setAcceptAllFileFilterUsed(false);
        this.mFileChooser.addChoosableFileFilter(new JpegFileFilter());
        this.mFileChooser.addChoosableFileFilter(new GifFileFilter());
        this.mFileChooser.setCurrentDirectory(new java.io.File(""));

        file.add(fileAdd);
        file.add(fileSave);
        menuBar.add(file);

        this.setLayout(new BorderLayout());
        this.add("Center", mCanvas);
        this.add(menuBar, BorderLayout.NORTH);
    }

    private GridBagConstraints getConstraints(int gridx, int gridy,
            int gridwidth, int gridheight, int anchor, int inset1, int inset2,
            int inset3, int inset4)
    {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(inset1, inset2, inset3, inset4);
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        c.gridheight = gridheight;
        c.anchor = anchor;
        return c;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        Object source = ae.getSource();
        if(source == this.fileAdd)
        {
            openFile();
        }
        
        if(source == this.fileSave)
        {
            saveFile();
        }

        mCanvas.repaint();
    }

    private void openFile()
    {
        if (mFileChooser.showOpenDialog(fileAdd) == JFileChooser.APPROVE_OPTION)
        {
            File imageFile = new File(mFileChooser.getCurrentDirectory() + "\\"
                    + mFileChooser.getSelectedFile().getName());
            try
            {

                mCanvas.setImage(imageFile);
            } catch (Exception e)
            {

            }
        }
    }
    
    private void saveFile()
    {
        // Save the same image file
        if (mFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {

            File imageFile = new File(mFileChooser.getCurrentDirectory() + "\\" +
                                      mFileChooser.getSelectedFile().getName());
            try
            {
                String fileType = mFileChooser.getSelectedFile().getName();
                if (fileType.contains(".gif"))
                {
                    fileType = "gif";
                }
                else
                {
                    fileType = "jpg";
                }

                ImageIO.write(mCanvas.getImage(), fileType, imageFile);

                
            }
            catch (Exception e)
            {

            }
        }
    }
}
