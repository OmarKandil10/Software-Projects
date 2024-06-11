import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WalkGUI
{
    public PrimaryGUI commands;
    public JPanel walkPanel;

    /**
     * Constructor for objects of class SwimGUI
     */
    public WalkGUI(PrimaryGUI commands)
    {
        walkPanel = new JPanel();
        JButton straight = new JButton("straight");
        JButton back = new JButton("back");
        JButton left = new JButton("left");
        JButton right = new JButton("right");
        
         straight.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            commands.textArea.append("\nStraight button was Pressed");
            commands.showMainPanel();
        }
       });
       
       
       back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            commands.textArea.append("\nBack button was Pressed");
            commands.showMainPanel();
        }
       });
       
       left.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            commands.textArea.append("\nLeft button was Pressed");
            commands.showMainPanel();
        }
       });
       
       right.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            commands.textArea.append("\nRight button was Pressed");
            commands.showMainPanel();
        }
       });
       
       walkPanel.add(straight);
        walkPanel.add(back);
        walkPanel.add(left);
        walkPanel.add(right);
    }
    
    
    

}
