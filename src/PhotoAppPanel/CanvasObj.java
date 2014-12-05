/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PhotoAppPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Anthony
 */
public class CanvasObj extends JPanel
{
    private BufferedImage image = null;
    private Vector<File> vector;
   

    public CanvasObj()
    {
        super();
        this.setSize(new Dimension(300,200));
        this.setBackground(Color.WHITE);
        this.setVisible(true);
        this.vector = new Vector<File>();
    }

    public void setImages(Vector<File> vectorImages)
    {
        if (vectorImages != null)
        {
            
            vector = vectorImages;
            
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
        
        try
        {
            Iterator iterator = vector.iterator();

            while(iterator.hasNext())
            {
                File file = (File)iterator.next();
                image = ImageIO.read(file);

                 g.drawImage(this.image, 0, 0,this.getWidth(),this.getHeight(), this);
            }

        }
        catch (Exception e)
        {
            
        }
    }
}

