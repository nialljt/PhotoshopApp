/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhotoAppPanel;

import ImageObject.ComboBoxCellRenderer;
import ImageObject.ImageCellRenderer;
import ImageObject.ImageObj;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.LookupOp;
import java.awt.image.RescaleOp;
import java.awt.image.ShortLookupTable;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
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
    private ImageIcon grayScaleButtonIcon = new ImageIcon(getClass().getClassLoader().getResource("images/alert-32.png"));
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
    private JPanel addTextPanel = new JPanel();    
    private JButton grayScaleButton = new JButton();
    private JButton originalButton = new JButton();
    private JButton blueScaleButton = new JButton();
    
    Color[] colors={Color.red,Color.blue,Color.green, Color.BLACK, Color.PINK,Color.white,Color.ORANGE};
    private JButton addTextButton = new JButton("Add");
    private JComboBox colorChoices = new JComboBox(colors);
    private JTextField addTextField = new JTextField(20);

    int testX = 0;
    int testY = 0;

    public PhotoAppPanel()
    {
        super();

        this.setBackground(Color.BLUE);

        mList.setCellRenderer(new ImageCellRenderer());
        mList.setVisibleRowCount(10);
        
        colorChoices.setRenderer(new ComboBoxCellRenderer());

        fileAdd.addActionListener(this);
        fileSave.addActionListener(this);
        mList.addKeyListener(this);
        mList.addListSelectionListener(this);

        fileAdd.setToolTipText("Add a new image to the collage");
        fileSave.setToolTipText("Save a file to your drive");
        
        grayScaleButton.setToolTipText("Gray Scale");
        originalButton.setToolTipText("Original");
        blueScaleButton.setToolTipText("Blue Scale");

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
        effectsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Effects"));
        addTextPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Add Text"));
        mCanvas.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        effectsPanel.setLayout(new FlowLayout());

       //grayScaleButton.setIcon(grayScaleButtonIcon);
        grayScaleButton.addActionListener(this);
        originalButton.addActionListener(this);
        blueScaleButton.addActionListener(this);
        addTextButton.addActionListener(this);
        effectsPanel.add(grayScaleButton);
        effectsPanel.add(originalButton);
        effectsPanel.add(blueScaleButton);
        
        grayScaleButton.setPreferredSize(new Dimension(50,50));
        originalButton.setPreferredSize(new Dimension(50,50));
        blueScaleButton.setPreferredSize(new Dimension(50,50));
        
        addTextPanel.setLayout(new GridLayout(3,1));
        addTextPanel.add(addTextField);
        addTextPanel.add(colorChoices);
        addTextPanel.add(addTextButton);

        toolsPanel.setLayout(new GridLayout(3,1));
        toolsPanel.add(layersScrollPane);
        toolsPanel.add(effectsPanel);
        toolsPanel.add(addTextPanel);

        mCanvas.addMouseMotionListener(mCanvas);

        this.setLayout(new BorderLayout());
        this.add(mCanvas, BorderLayout.CENTER);
        this.add(menuBar, BorderLayout.NORTH);
        this.add(toolsPanel, BorderLayout.EAST);

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
        if (source == this.fileAdd)
        {
            openFile();
        }

        if (source == this.fileSave)
        {
            saveFile();
        }

        if (source == this.grayScaleButton)
        {
            grayScale();
        }

        if (source == this.originalButton)
        {
            original();
        }
        if (source == this.blueScaleButton)
        {
            blueScale();
        }
        if(source == this.addTextButton){
            if(!addTextField.getText().isEmpty()){
            addText();
            addTextField.setText("");
            }
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
                BufferedImage tmpimg = ImageIO.read(imageFile);
                imgVector.add(new ImageObj(imageFile.getName(), tmpimg, 0, 0, tmpimg.getHeight(), tmpimg.getWidth(), 0, imageFile));
                mCanvas.setImages(imgVector);
                mList.setListData(imgVector);
                if (imgVector.size() == 1)
                {
                    mList.setSelectedIndex(0);
                }
               
            } catch (Exception e)
            {

            }
        }
    }

    private void saveFile()
    {

        BufferedImage saveImage = new BufferedImage(mCanvas.getWidth(), mCanvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) saveImage.getGraphics();

        mCanvas.paint(g2);

        if (mFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            File imageFile = new File(this.mFileChooser.getCurrentDirectory() + "\\"
                    + this.mFileChooser.getSelectedFile().getName());

            try
            {
                String fileType = mFileChooser.getSelectedFile().getName();
                if (fileType.contains(".gif"))
                {
                    fileType = "gif";
                } else if (fileType.contains(".jpg"))
                {
                    fileType = "jpg";
                } else
                {
                    fileType = "png";
                }

                ImageIO.write(saveImage, fileType, imageFile);

            } catch (Exception e)
            {

            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke)
    {
        // If user presses Delete key,

        ImageObj selectedObject = imgVector.get(mList.getSelectedIndex());

        int keyCode = ke.getKeyCode();

        if (keyCode == KeyEvent.VK_DELETE)
        {
            // Remove the selected item
            imgVector.remove(mList.getSelectedValue());

            // Now set the updated vector (updated items)
            mList.setListData(imgVector);

        }

        if (keyCode == KeyEvent.VK_RIGHT)
        {
            selectedObject.setRotate(selectedObject.getRotate() + 1);
        }

        if (keyCode == KeyEvent.VK_LEFT)
        {
            selectedObject.setRotate(selectedObject.getRotate() - 1);
        }

        if (keyCode == KeyEvent.VK_ADD)
        {
            selectedObject.setHeight(selectedObject.getHeight() + 1);
            selectedObject.setWidth(selectedObject.getWidth() + 1);
        }

        if (keyCode == KeyEvent.VK_SUBTRACT)
        {
            selectedObject.setHeight(selectedObject.getHeight() - 1);
            selectedObject.setWidth(selectedObject.getWidth() - 1);
        }
        if (keyCode == KeyEvent.VK_UP)
        {
            if(imgVector.size()> 1){
                Vector<ImageObj> tmpVec = new Vector<ImageObj>();
                for(int i = 0; i < imgVector.size();i++){
                    if(i == (mList.getSelectedIndex() - 1)){
                        tmpVec.add(imgVector.get(i+1));
                    }else if(i == mList.getSelectedIndex()){
                        tmpVec.add(imgVector.get(i-1));
                    }else{
                        tmpVec.add(imgVector.get(i));
                    }
                }
                imgVector.clear();
                
                for(ImageObj imOb: tmpVec){
                    imgVector.add(imOb);
                }
               
            }
        }
        if (keyCode == KeyEvent.VK_DOWN)
        {
            if(imgVector.size()> 1){
                Vector<ImageObj> tmpVec = new Vector<ImageObj>();
                for(int i = 0; i < imgVector.size();i++){
                    if(i == (mList.getSelectedIndex())){
                        tmpVec.add(imgVector.get(i+1));
                    }else if(i == mList.getSelectedIndex()+1){
                        tmpVec.add(imgVector.get(i-1));
                    }else{
                        tmpVec.add(imgVector.get(i));
                    }
                }
                imgVector.clear();
                
                for(ImageObj imOb: tmpVec){
                    imgVector.add(imOb);
                }
               
            }
        }

        mCanvas.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke)
    {
    }

    @Override
    public void keyTyped(KeyEvent ke)
    {
    }

    @Override
    public void valueChanged(ListSelectionEvent lse)
    {
        imgVector.get(mList.getSelectedIndex()).setIsSelected(true);
        for (int i = 0; i < imgVector.size(); i++)
        {
            if (i != mList.getSelectedIndex())
            {
                imgVector.get(i).setIsSelected(false);
            }
        }
        
    }

    private void grayScale()
    {
        try
        {
            imgVector.get(mList.getSelectedIndex()).setImg(ImageIO.read(imgVector.get(mList.getSelectedIndex()).getOriginalImg()));
        } catch (IOException ex)
        {
            Logger.getLogger(PhotoAppPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedImage tmpImg = imgVector.get(mList.getSelectedIndex()).getImg();
        for (int i = 0; i < tmpImg.getHeight(); i++)
        {
            for (int j = 0; j < tmpImg.getWidth(); j++)
            {
                Color c = new Color(tmpImg.getRGB(j, i));
                int red = (int) (c.getRed() * 0.299);
                int green = (int) (c.getGreen() * 0.587);
                int blue = (int) (c.getBlue() * 0.114);
                Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);
                tmpImg.setRGB(j, i, newColor.getRGB());
                //imgVector.get(mList.getSelectedIndex()).setImg(tmpImg);
            }
        }
    }

    private void blueScale()
    {
        try
        {
            imgVector.get(mList.getSelectedIndex()).setImg(ImageIO.read(imgVector.get(mList.getSelectedIndex()).getOriginalImg()));
        } catch (IOException ex)
        {
            Logger.getLogger(PhotoAppPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedImage tmpImg = imgVector.get(mList.getSelectedIndex()).getImg();

        float blueScale[] =
        {
            1.0f, 1.0f, 5.0f
        };
        float blueOffset[] =
        {
            0.0f, 0.0f, -150.0f
        };
        RescaleOp rescaleOp = new RescaleOp(blueScale,blueOffset,null);
        BufferedImage destBufferedImg = rescaleOp.filter(tmpImg, null);
        imgVector.get(mList.getSelectedIndex()).setImg(destBufferedImg);
        
    }
    private void original()
    {

        try
        {
            imgVector.get(mList.getSelectedIndex()).setImg(ImageIO.read(imgVector.get(mList.getSelectedIndex()).getOriginalImg()));
        } catch (IOException ex)
        {
            Logger.getLogger(PhotoAppPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addText()
    {
               
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Arial", Font.PLAIN, 48);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(addTextField.getText());
        int height = fm.getHeight();
        g2d.dispose();

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(colors[colorChoices.getSelectedIndex()]);
        g2d.drawString(addTextField.getText(), 0, fm.getAscent());
        g2d.dispose();
        imgVector.add(new ImageObj(addTextField.getText(), img,0,0,img.getWidth(),img.getHeight(), 0));
        mCanvas.setImages(imgVector);
                mList.setListData(imgVector);
        this.repaint();
    }
}
