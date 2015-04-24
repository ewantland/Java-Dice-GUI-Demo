
package dicegui;

import javax.swing.JFrame;

/**
 *
 * @author ebw
 */

public class DiceGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(() -> {
            makeGUI();
        });    
    }    
        
// to build to GUI
    private static void makeGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("Dice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JFrame frame2 = new JFrame("Play");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        D6Panel theDicePanel = new D6Panel();
        theDicePanel.setOpaque(true); //content panes must be opaque
        
        
        
        
        // set the base Pane for the window
        frame.setContentPane(theDicePanel);

        //Display the window.
        frame.pack();
        frame.setResizable(false);
        //frame.setOpacity(0.5f);
        frame.setVisible(true);
    }
    
}

