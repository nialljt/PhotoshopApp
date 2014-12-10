/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhotoAppPanel;

import ImageObject.ImageObj;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
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
public class CanvasObj extends JPanel implements MouseMotionListener
{

    private BufferedImage image = null;
    private Vector<ImageObj> vector;

    public CanvasObj()
    {
        super();
        this.setSize(new Dimension(800, 800));
        // this.setBackground(Color.WHITE);
        this.setVisible(true);
        this.vector = new Vector<ImageObj>();
    }

    public void setImages(Vector<ImageObj> vectorImages)
    {
        if (!vectorImages.isEmpty())
        {
            vector = vectorImages;
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        try
        {
            Graphics2D g2d = (Graphics2D) g;
            g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
            Iterator<ImageObj> iterator = vector.iterator();

            while (iterator.hasNext())
            {
                ImageObj imgVector = iterator.next();
                g2d.rotate(Math.toRadians(imgVector.getRotate()), (imgVector.getxPos() + (imgVector.getWidth() / 2)), (imgVector.getyPos() + (imgVector.getHeight() / 2)));
                g2d.drawImage(imgVector.getImg(), imgVector.getxPos(), imgVector.getyPos(), imgVector.getWidth(), imgVector.getHeight(), this);
                g2d.rotate(Math.toRadians(-imgVector.getRotate()), (imgVector.getxPos() + (imgVector.getWidth() / 2)), (imgVector.getyPos() + (imgVector.getHeight() / 2)));
            }

        } catch (Exception e)
        {

        }
    }

       int previousx = 0;
       int previousy = 0;
    @Override
    public void mouseDragged(MouseEvent me)
    {
        
        for(ImageObj img : vector){
            if(img.isIsSelected()){
               if(previousx < me.getX()){
                    img.setxPos(img.getxPos()+1);
                }else{
                    img.setxPos(img.getxPos()-1);
                }
                if(previousy < me.getY()){
                    img.setyPos(img.getyPos()+1);
                }else{
                    img.setyPos(img.getyPos()-1);
                }
            }
        }
        previousx = me.getX();
        previousy = me.getY();
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent me)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
