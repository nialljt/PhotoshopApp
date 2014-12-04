/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PhotoAppPanel;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Anthony
 */
public class JpegFileFilter extends FileFilter
{
    @Override
    public boolean accept(File file)
    {
        if (file.isDirectory())
        {
            return true;
        }

        String fileName = file.getName().toLowerCase();
        return (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".jpe"));
    }

    @Override
    public String getDescription()
    {
        return ("JPEG (*.JPG, *.JPEG and *.JPE)");
    }
}
