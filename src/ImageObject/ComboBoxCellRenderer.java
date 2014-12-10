package ImageObject;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Niall
 */
public class ComboBoxCellRenderer extends JButton implements ListCellRenderer {  
     public ComboBoxCellRenderer() {  
         setOpaque(true); 

     }
     boolean b=false;
    @Override
    public void setBackground(Color bg) {
        // TODO Auto-generated method stub
         if(!b)
         {
             return;
         }

        super.setBackground(bg);
    }
     public Component getListCellRendererComponent(  
         JList list,  
         Object value,  
         int index,  

         boolean isSelected,  
         boolean cellHasFocus)  
     {  

         b=true;
         setText(" ");           
         setBackground((Color)value);        
         b=false;
         return this;  
     }  
}