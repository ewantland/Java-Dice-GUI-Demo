

package dicegui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ebw
 */
public class ButtonPanel extends JPanel implements ActionListener{
    
    protected JButton rollAll;
    protected JButton clear;
    
    public ButtonPanel(){
        super();
        
        rollAll = new JButton("Roll");
        rollAll.addActionListener(this);
        rollAll.setActionCommand("all");
        add(rollAll);
        
        clear = new JButton("Clear");
        clear.addActionListener(this);
        clear.setActionCommand("clear");
        add(rollAll);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        String event = ae.getActionCommand();
        
        if(event == "all"){
            
        } else if (event == "clear"){
            
        }
        
    }
    

}
