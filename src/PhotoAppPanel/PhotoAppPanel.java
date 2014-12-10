/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PhotoAppPanel;

import ImageObject.ImageCellRenderer;
import ImageObject.ImageObj;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Anthony
 */
public class PhotoAppPanel extends JPanel implements ActionListener, KeyListener, ListSelectionListener
{
    private JMenuBar menuBar = new JMenuBar();
    private ImageIcon addImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/Add_icon.png"));
    private ImageIcon saveImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/Add_icon.png"));
    private ImageIcon blackAndWhiteButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("images/alert-32.png"));
    private ImageIcon textButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("images/alert-32.png"));
    private JMenu file = new JMenu("File");
    private JMenuItem fileAdd = new JMenuItem("Add", addImageIcon);
    private JMenuItem fileSave = new JMenuItem("Save", saveImageIcon);
    private JFileChooser mFileChooser = new JFileChooser();
    private CanvasObj mCanvas = new CanvasObj();
    private Vector<ImageObj> imgVector = new Vector<ImageObj>();
    private JList mList = new JList();
    private JScrollPane layersScrollPane = new JScrollPane(mList);
    private JLabel mLayersLabel = new JLabel("Layers");
    private JPanel toolsPanel = new JPanel();
    private JPanel effectsPanel = new JPanel();
    private JButton blackAndWhiteButton = new JButton();
    

    int testX= 0;
    int testY= 0;

    public PhotoAppPanel()
    {
        super();

        this.setBackground(Color.BLUE);

        
        mList.setCellRenderer(new ImageCellRenderer());
        mList.setVisibleRowCount(10);
        
        
        fileAdd.addActionListener(this);
        fileSave.addActionListener(this);
        mList.addKeyListener(this);
        mList.addListSelectionListener(this);
        
        fileAdd.setToolTipText("Add a new image to the collage");
        fileSave.setToolTipText("Save a file to your drive");

        this.mFileChooser.setAcceptAllFileFilterUsed(false);
        this.mFileChooser.addChoosableFileFilter(new JpegFileFilter());
        this.mFileChooser.addChoosableFileFilter(new GifFileFilter());
        this.mFileChooser.addChoosableFileFilter(new PingFileFilter());
        this.mFileChooser.setCurrentDirectory(new java.io.File(""));

        file.add(fileAdd);
        file.add(fileSave);
        menuBar.add(file);

        
        mList.setVisibleRowCount(10);
        mList.setFixedCellHeight(25);
        mList.setFixedCellWidth(200);
        
       
        
        layersScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Layers"));
        effectsPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        mCanvas.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        
        effectsPanel.setLayout(new GridLayout(4,2));
        
                    
        blackAndWhiteButton.setIcon(blackAndWhiteButtonIcon);
       blackAndWhiteButton.setEnabled(false);
        effectsPanel.add(blackAndWhiteButton);
        
        toolsPanel.setLayout(new BorderLayout());
        toolsPanel.add(layersScrollPane,"North");
        toolsPanel.add(effectsPanel,"Center");
                
        mCanvas.addMouseMotionListener(mCanvas);
        
        this.setLayout(new BorderLayout());
        this.add("Center", mCanvas);
        this.add(menuBar, BorderLayout.NORTH);
        this.add(toolsPanel, BorderLayout.EAST);
        
        testX= mCanvas.getX()/2;
        testY=mCanvas.getY()/2;
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
                imgVector.add(new ImageObj(imageFile.getName(), (BufferedImage)ImageIO.read(imageFile),testX,testY,mCanvas.getWidth(), mCanvas.getHeight(),0));
                mCanvas.setImages(imgVector);
                mList.setListData(imgVector); 
                if(imgVector.size() == 1){
                    mList.setSelectedIndex(0);
                }
                testX = testX + 50;
                testY = testY + 50;
                
            } catch (Exception e)
            {

            }
        }
    }
    
    private void saveFile()
    {
        
        BufferedImage saveImage = new BufferedImage(mCanvas.getWidth(), mCanvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2=(Graphics2D)saveImage.getGraphics();
        
        mCanvas.paint(g2);
     
        if (mFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            File imageFile = new File(this.mFileChooser.getCurrentDirectory() + "\\" +
                                          this.mFileChooser.getSelectedFile().getName());
            
            try
            {
                String fileType = mFileChooser.getSelectedFile().getName();
                if (fileType.contains(".gif"))
                {
                    fileType = "gif";
                }
                else if(fileType.contains(".jpg"))
                {
                    fileType = "jpg";
                }
                else
                {
                    fileType = "png";
                }
                
                ImageIO.write(saveImage, fileType, imageFile);
                
            }
            catch (Exception e)
            {

            }
        }
    }


    @Override
    public void keyPressed(KeyEvent ke) {
        // If user presses Delete key,
        
        ImageObj selectedObject = imgVector.get(mList.getSelectedIndex());
        
        int keyCode = ke.getKeyCode();
        
        if(keyCode==KeyEvent.VK_DELETE)
        {
            // Remove the selected item
            imgVector.remove(mList.getSelectedValue());

            // Now set the updated vector (updated items)
            mList.setListData(imgVector);

            
        }
        
        if(keyCode==KeyEvent.VK_RIGHT)
        {
            selectedObject.setRotate(selectedObject.getRotate() + 1);
        }
        
        if(keyCode==KeyEvent.VK_LEFT)
        {
            selectedObject.setRotate(selectedObject.getRotate() - 1);
        }
        
        if(keyCode==KeyEvent.VK_ADD)
        {           
            selectedObject.setHeight(selectedObject.getHeight() + 1);
            selectedObject.setWidth(selectedObject.getWidth() + 1);
        }
        
        if(keyCode==KeyEvent.VK_SUBTRACT)
        {        
            selectedObject.setHeight(selectedObject.getHeight() - 1);
            selectedObject.setWidth(selectedObject.getWidth() - 1);
        }
        
        mCanvas.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {}
    
    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void valueChanged(ListSelectionEvent lse)
    {
        imgVector.get(mList.getSelectedIndex()).setIsSelected(true);
        for(int i = 0; i < imgVector.size(); i++){
            if(i != mList.getSelectedIndex()){
                imgVector.get(i).setIsSelected(false);
            }
        }
    }
}

