

package dicegui;

// a D6Panel will be a JPanel
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ebw
 */

public class D6Panel extends JPanel implements ActionListener{
    
    protected int size;
    protected D6Button[] dice;
    protected JButton rollAll;
    protected JButton clear;
    
    
    public D6Panel(){        
        super();
        size = 5;
        
        dice = new D6Button[size];
        
        for(int i = 0; i < size; i++){
            dice[i] = new D6Button();
            dice[i].addActionListener(this);
            dice[i].setActionCommand(new Integer(i).toString());
            add(dice[i]);
        }
        
        rollAll = new JButton("Roll");
        rollAll.addActionListener(this);
        rollAll.setActionCommand("-1");
        add(rollAll);
        
        clear = new JButton("Clear");
        clear.addActionListener(this);
        clear.setActionCommand("-2");
        add(clear);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        
        int action = new Integer(ae.getActionCommand());
        
        if(action > -1){
        
            if(dice[action].stuck){
                dice[action].setUnStuck();
                //dice[action].roll();
            } else {    
                dice[action].setStuck();
            }
        } else if(action == -1){
            for(int i = 0; i < size; i++){
                if(!dice[i].stuck){
                    dice[i].roll();
                }
            }
            
        } else if(action == -2){
            for(int i = 0; i < size; i++){
                dice[i].setUnStuck();
            }
        } 
    }

}
