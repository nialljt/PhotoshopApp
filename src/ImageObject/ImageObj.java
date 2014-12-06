package ImageObject;

import java.awt.Image;
import java.io.File;
import java.awt.image.BufferedImage;

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
    private boolean shouldDraw;
    
    public ImageObj(String mFileName,BufferedImage img, int xPos, int yPos)

    {
        this.mFileName = mFileName;
        this.xPos = xPos;
        this.yPos = yPos;
        this.img = img;


        shouldDraw = true;
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

    public Image getImg()
    {
        return img;
    }

    public void setImg(BufferedImage img)
    {
        this.img = img;
    }

    public boolean isShouldDraw()
    {
        return shouldDraw;
    }

    public void setShouldDraw(boolean shouldDraw)
    {
        this.shouldDraw = shouldDraw;
    }
    
    
}
