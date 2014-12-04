package PhotoAppPanel;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class GifFileFilter extends FileFilter
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