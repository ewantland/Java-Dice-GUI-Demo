
package dicegui;


// a D6Button will be a special JButton
import java.awt.Image;
import java.util.Random;
import javax.swing.JButton;

// we will use ImageIcons on the buttons
import javax.swing.ImageIcon;



/**
 *
 * @author ebw
 */

public class D6Button extends JButton{
    
    protected static ImageIcon[] D6Icon;
    protected static int SIDES = 6;
    protected static Random randy;
    protected int value;
    protected boolean stuck;
    
    // CONSTRUCTOR
    
    public D6Button(){
        super();
        
        randy = new Random();
        stuck = false;
        D6Icon = new ImageIcon[12];    
        for(int i = 0; i < SIDES; i++){
            String path1 = "images/"+(i+1)*10+".jpg";
            String path2 = "images/"+(i+1)*11+".jpg";
            System.out.println(path1 + " " + path2);
            D6Icon[i] = createImageIcon(path1);
            D6Icon[i+SIDES] = createImageIcon(path2);
        }
    
        for(int i = 0; i < D6Icon.length; i++){
               Image img = D6Icon[i].getImage();
               Image newimg = img.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH);
               D6Icon[i] = new ImageIcon(newimg);
        }
        
        
        //sets value and Icon
        roll();
    
        
        
    }
    
    protected void roll(){
        if(!stuck) value = randy.nextInt(SIDES) + 1;
        System.out.println(value);
        this.setIcon(D6Icon[value-1]);
    }
    
    protected void setStuck(){
        if(!this.stuck) this.setIcon(D6Icon[this.value-1+6]);
        stuck = true;       
    }
    
    protected void setUnStuck(){
        if(this.stuck) this.setIcon(D6Icon[this.value-1]);
        stuck = false;       
    }
    
    
    protected static ImageIcon createImageIcon(String path) {
        
        // we give this the relative path to the precise file
        // and we get a Uniform Resource Locater for reference
        
        java.net.URL imgURL = DiceGUI.class.getResource(path);
        if (imgURL != null) {
            // here is where the file (of appropriate type)
            // is converted to a file appropriate for the GUI
            // the input is the location of the file
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    
    
}
