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
public class PingFileFilter extends FileFilter
{
    @Override
    public boolean accept(File file)
    {
        if (file.isDirectory())
        {
            return true;
        }

        String name = file.getName().toLowerCase();
        return (name.endsWith(".png"));
    }

    @Override
    public String getDescription()
    {
        return ("CompuServe PNG (*.PNG)");
    }
}
