package ImageObject;

/**
 *
 * @author Niall
 */
public class ImageObj {
    private String mFileName;
    private String mPath;
    private int xPos;
    private int yPos;

    public ImageObj(String mFileName, String mPath, int xPos, int yPos)
    {
        this.mFileName = mFileName;
        this.mPath = mPath;
        this.xPos = xPos;
        this.yPos = yPos;
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
    
    

}
