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
<<<<<<< HEAD
    private BufferedImage image = null;
    private Vector<File> vector;
   
=======
   // private BufferedImage image = null;
>>>>>>> origin/master

    public CanvasObj()
    {
        super();
        this.setSize(new Dimension(300,200));
       // this.setBackground(Color.WHITE);
        this.setVisible(true);
        this.vector = new Vector<File>();
    }

<<<<<<< HEAD
    public void setImages(Vector<File> vectorImages)
=======
/*   public void setImage(File imageFile)
>>>>>>> origin/master
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
*/
    @Override
    public void paintComponent(Graphics g)
    {
<<<<<<< HEAD
        
        try
        {
            Iterator iterator = vector.iterator();
=======
        //super.paintComponent(g);
       // if (this.image != null)
       // {
            //final Graphics2D g2d = this.image.createGraphics();
>>>>>>> origin/master

            while(iterator.hasNext())
            {
                File file = (File)iterator.next();
                image = ImageIO.read(file);

<<<<<<< HEAD
                 g.drawImage(this.image, 0, 0,this.getWidth(),this.getHeight(), this);
            }

        }
        catch (Exception e)
        {
            
        }
=======
            // paint the modified image
            for(int i = 0; i< PhotoAppPanel.imgVector.size(); i++){
            g.drawImage(PhotoAppPanel.imgVector.get(i).getImg(),PhotoAppPanel.imgVector.get(i).getxPos() , PhotoAppPanel.imgVector.get(i).getyPos(),this.getWidth()/2,this.getHeight()/2, this);
            }
           // g.drawImage(this.image, 0, 0,this.getWidth()/2,this.getHeight()/2, this);
       // }
      //  else // no image displayed yet
       // {

       // }
>>>>>>> origin/master
    }
}

