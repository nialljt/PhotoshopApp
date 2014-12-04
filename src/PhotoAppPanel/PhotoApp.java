package PhotoAppPanel;

import ImageObject.ImageObj;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Niall
 */
public class PhotoApp extends JApplet implements ActionListener
{

    public void init()
    {
        this.setBackground(Color.yellow);
        JPanel panel = new PhotoAppPanel();
        add(panel);
        this.setVisible(true);
    }

    public class PhotoAppPanel extends JPanel
    {

        private JMenuBar menuBar = new JMenuBar();
        private ImageIcon addImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/Add_icon.png"));

        private JMenu file = new JMenu("File");

        private JMenuItem fileAdd = new JMenuItem("Add", addImageIcon);

        private JButton mOpenButton = new JButton("Open");
        private JFileChooser mFileChooser;
        private Canvas mCanvas = new Canvas();
        private Vector<ImageObj> imgVector = new Vector<ImageObj>();
        private JPanel mButtonPanel = new JPanel(), mImagePanel = new JPanel();

        public PhotoAppPanel()
        {
            super();
            
            this.setBackground(Color.BLUE);
            
            fileAdd.setToolTipText("Add a new image to the collage");
            fileAdd.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    mFileChooser = new JFileChooser();
                    mFileChooser.setAcceptAllFileFilterUsed(false);
                    mFileChooser.addChoosableFileFilter(new JpegFileFilter());
                    mFileChooser.addChoosableFileFilter(new GifFileFilter());
                    mFileChooser.setCurrentDirectory(new java.io.File(""));
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
                    mCanvas.repaint();
                }
            });

            file.add(fileAdd);
            menuBar.add(file);
            setJMenuBar(menuBar);

            this.setLayout(new BorderLayout());
           this.add("Center", mCanvas);
          //this.add("South",mOpenButton);
            //mCanvas.setb
            //add(mCanvas);
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
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class JpegFileFilter extends FileFilter
    {

        @Override
        public boolean accept(File file)
        {
            if (file.isDirectory())
            {
                return true;
            }

            String fileName = file.getName().toLowerCase();
            return (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".jpe"));
        }

        @Override
        public String getDescription()
        {
            return ("JPEG (*.JPG, *.JPEG and *.JPE)");
        }
    }

    private class GifFileFilter extends FileFilter
    {

        @Override
        public boolean accept(File file)
        {
            if (file.isDirectory())
            {
                return true;
            }

            String name = file.getName().toLowerCase();
            return (name.endsWith(".gif"));
        }

        @Override
        public String getDescription()
        {
            return ("CompuServe GIF (*.GIF)");
        }
    }

    public class Canvas extends JPanel
    {
        private BufferedImage image = null;

        public Canvas()
        {
            super();
            this.setSize(new Dimension(300,200));
            this.setBackground(Color.PINK);
            this.setVisible(true);
        }

        public void setImage(File imageFile)
        {
            if (imageFile != null)
            {
                try
                {
                    image = ImageIO.read(imageFile);
                }
                catch (Exception e)
                {
                }
            }
            else // imageFile == null
            {
                // reset the image to empty
                image = null;
            }
        }

        public BufferedImage getImage()
        {
            return image;
        }
        
        @Override
        public void paintComponent(Graphics g)
        {
            //super.paintComponent(g);
            if (this.image != null)
            {
                final Graphics2D g2d = this.image.createGraphics();

                // perform a simple manipulatation of the inputted image
               // g2d.setColor(Color.red);
               // g2d.fillOval(this.image.getWidth() / 4, this.image.getHeight() / 4,
                           //  this.image.getWidth() / 2, this.image.getHeight() / 2);

                // paint the modified image
                g.drawImage(this.image, 0, 0,this.getWidth(),this.getHeight(), this);
                
            }
            else // no image displayed yet
            {
                                
            }
        }
    }
}
