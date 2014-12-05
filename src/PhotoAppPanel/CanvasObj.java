/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PhotoAppPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Anthony
 */
public class CanvasObj extends JPanel
{
   // private BufferedImage image = null;

    public CanvasObj()
    {
        super();
        this.setSize(new Dimension(300,200));
       // this.setBackground(Color.WHITE);
        this.setVisible(true);
    }

/*   public void setImage(File imageFile)
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
*/
    @Override
    public void paintComponent(Graphics g)
    {
        //super.paintComponent(g);
       // if (this.image != null)
       // {
            //final Graphics2D g2d = this.image.createGraphics();

            // perform a simple manipulatation of the inputted image
           // g2d.setColor(Color.red);
           // g2d.fillOval(this.image.getWidth() / 4, this.image.getHeight() / 4,
                       //  this.image.getWidth() / 2, this.image.getHeight() / 2);

            // paint the modified image
            for(int i = 0; i< PhotoAppPanel.imgVector.size(); i++){
            g.drawImage(PhotoAppPanel.imgVector.get(i).getImg(),PhotoAppPanel.imgVector.get(i).getxPos() , PhotoAppPanel.imgVector.get(i).getyPos(),this.getWidth()/2,this.getHeight()/2, this);
            }
           // g.drawImage(this.image, 0, 0,this.getWidth()/2,this.getHeight()/2, this);
       // }
      //  else // no image displayed yet
       // {

       // }
    }
}

