package ImageObject;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author Niall
 */
public class ImageObj 
{
    private String mFileName;
    private int xPos;
    private int yPos;
    private BufferedImage img;
    private boolean isSelected;
    private int rotate;
    private int height;
    private int width;
    private File originalImg;
    
    public ImageObj(String mFileName,BufferedImage img, int xPos, int yPos, 
            int height, int width, int rotate, File original)
    {
        this.mFileName = mFileName;
        this.xPos = xPos;
        this.yPos = yPos;
        this.img = img;
        this.rotate = rotate;
        this.height = height;
        this.width = width;
        isSelected = false;
        this.originalImg = original;
    }

    public ImageObj(String mFileName,BufferedImage img, int xPos, int yPos, 
            int height, int width, int rotate)
    {
        this.mFileName = mFileName;
        this.xPos = xPos;
        this.yPos = yPos;
        this.img = img;
        this.rotate = rotate;
        this.height = height;
        this.width = width;
        isSelected = false;
        this.originalImg = null;
    }
    public int getRotate() {
        return rotate;
    }

    public void setRotate(int rotate) {
        this.rotate = rotate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getmFileName()
    {
        return mFileName;
    }

    public void setmFileName(String mFileName)
    {
        this.mFileName = mFileName;
    }

    public int getxPos()
    {
        return xPos;
    }

    public void setxPos(int xPos)
    {
        this.xPos = xPos;
    }

    public int getyPos()
    {
        return yPos;
    }

    public void setyPos(int yPos)
    {
        this.yPos = yPos;
    }

    public BufferedImage getImg()
    {
        return img;
    }

    public void setImg(BufferedImage img)
    {
        this.img = img;
    }
    
    public ImageIcon getIcon()
    {
       Image resizedImage = img.getScaledInstance(30, 30, 0);
       ImageIcon icon = new ImageIcon(resizedImage); 
       
       return icon;
    }

    public boolean isIsSelected()
    {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected)
    {
        this.isSelected = isSelected;
    }

    public File getOriginalImg()
    {
        return originalImg;
    }

   
}