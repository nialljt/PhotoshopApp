package ImageObject;

import java.awt.Image;
import java.io.File;

/**
 *
 * @author Niall
 */
public class ImageObj 
{
    private String mFileName;
    private String mPath;
    private int xPos;
    private int yPos;
    private Image img;
    private File file;
    
    public ImageObj()
    {
        this.mFileName = mFileName;
        this.mPath = mPath;
        this.xPos = xPos;
        this.yPos = yPos;
        this.img = img;
        this.file = new File("");
    }

    public String getmFileName()
    {
        return mFileName;
    }

    public void setmFileName(String mFileName)
    {
        this.mFileName = mFileName;
    }

    public String getmPath()
    {
        return mPath;
    }

    public void setmPath(String mPath)
    {
        this.mPath = mPath;
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

    public void setImg(Image img)
    {
        this.img = img;
    }
}
