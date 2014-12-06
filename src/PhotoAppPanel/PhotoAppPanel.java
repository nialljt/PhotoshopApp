/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PhotoAppPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
=======
import java.awt.image.BufferedImage;
>>>>>>> origin/master
import java.io.File;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Anthony
 */
public class PhotoAppPanel extends JPanel implements ActionListener, KeyListener
{
    private JMenuBar menuBar = new JMenuBar();
    private ImageIcon addImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/Add_icon.png"));
    private ImageIcon saveImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/Add_icon.png"));
    private JMenu file = new JMenu("File");
    private JMenuItem fileAdd = new JMenuItem("Add", addImageIcon);
    private JMenuItem fileSave = new JMenuItem("Save", saveImageIcon);
    private JFileChooser mFileChooser = new JFileChooser();
    private CanvasObj mCanvas = new CanvasObj();
<<<<<<< HEAD
    private Vector<File> imgVector = new Vector<File>();
    private JPanel mButtonPanel = new JPanel(), mImagePanel = new JPanel();
    private String names[] = {"Anthony","Fernandes"};
    private JList mList = new JList();
    
=======
    public static Vector<ImageObj> imgVector = new Vector<ImageObj>();
    private JPanel mButtonPanel = new JPanel(), mImagePanel = new JPanel();
    
    int testX=0;
    int testY=0;
>>>>>>> origin/master

    public PhotoAppPanel()
    {
        super();

        this.setBackground(Color.BLUE);

        mList = new JList(imgVector);
        mList.setVisibleRowCount(10);
        
        fileAdd.addActionListener(this);
        fileSave.addActionListener(this);
        mList.addKeyListener(this);
        
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
        this.add(mList, BorderLayout.EAST);
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

        //here we will repaint the entire vector
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
<<<<<<< HEAD
                //Here we will add a new vector set
                imgVector.add(imageFile);
                mCanvas.setImages(imgVector);
                
                mList.setListData(imgVector);
=======
                imgVector.add(new ImageObj(imageFile.getName(), (BufferedImage)ImageIO.read(imageFile),testX,testY));
                testX = mCanvas.getWidth()/2;
                mCanvas.repaint();
                //mCanvas.setImage(imageFile);   
>>>>>>> origin/master
                
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

                //ImageIO.write(mCanvas.getImage(), fileType, imageFile);

                
            }
            catch (Exception e)
            {

            }
        }
    }


    @Override
    public void keyPressed(KeyEvent ke) {
        // If user presses Delete key,
        if(ke.getKeyCode()==KeyEvent.VK_DELETE)
        {

            // Remove the selected item
            imgVector.remove(mList.getSelectedValue());

            // Now set the updated vector (updated items)
            mList.setListData(imgVector);

            mCanvas.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {}
    
    @Override
    public void keyTyped(KeyEvent ke) {}
}

