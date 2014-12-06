package ImageObject;

import java.awt.Image;
<<<<<<< HEAD
import java.io.File;
=======
import java.awt.image.BufferedImage;
>>>>>>> origin/master

/**
 *
 * @author Niall
 */
public class ImageObj 
{
    private String mFileName;
    private int xPos;
    private int yPos;
<<<<<<< HEAD
    private Image img;
    private File file;
    
    public ImageObj()
=======
    private BufferedImage img;
    private boolean shouldDraw;
    
    public ImageObj(String mFileName,BufferedImage img, int xPos, int yPos)
>>>>>>> origin/master
    {
        this.mFileName = mFileName;
        this.xPos = xPos;
        this.yPos = yPos;
        this.img = img;
<<<<<<< HEAD
        this.file = new File("");
=======
        shouldDraw = true;
>>>>>>> origin/master
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
