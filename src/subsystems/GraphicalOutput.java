package subsystems;
import javax.swing.*;

public class GraphicalOutput {
    public static void main(String args[]){
        //Creates working application window
        JFrame testFrame = new JFrame("Test GUI");
            testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            testFrame.setSize(400,400);

        //Creates a button in the window
        JButton testButton = new JButton("Test Button");
        testFrame.getContentPane().add(testButton);
        testFrame.setVisible(true);

        //Creates Java GridBagLayout (formatting of objects in the window)
        //WIP
    }
}
