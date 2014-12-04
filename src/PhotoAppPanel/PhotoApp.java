package PhotoAppPanel;

import ImageObject.ImageObj;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;
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
            this.setLayout(new GridBagLayout());

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
                    mFileChooser.showOpenDialog(fileAdd);
                }
            });

            file.add(fileAdd);
            menuBar.add(file);

            setJMenuBar(menuBar);

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

}
