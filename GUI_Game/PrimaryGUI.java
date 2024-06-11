
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Write a description of class PrimaryGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class PrimaryGUI
{
    public JFrame frame;
    public JTextArea textArea;
    public JPanel mainPanel;
    public WalkGUI walkGUI;
    private Game player;
    private ConsoleUI ui;
    
    /**
     * Constructor for objects of class PrimaryGUI
     */
    public PrimaryGUI()
    {
        frame = new JFrame("Subway Hunt");
        frame.setSize(500, 250);
        frame.setLocation(300,200);
        textArea = new JTextArea(10, 40);
        frame.getContentPane().add(BorderLayout.NORTH, textArea);

        ImageIcon icon = new ImageIcon("shoppingCenter.png");;
        JLabel label = new JLabel(); 
        label.setIcon(icon);
        frame.add(label);
        

        mainPanel = new JPanel();
        walkGUI = new WalkGUI(this);
        player = new Game();
        ui = new ConsoleUI(player);
      
    }

    public void showMainPanel()
    {
        frame.dispose();
        main();
    }

    public static void main()
    {
        PrimaryGUI gui = new PrimaryGUI();
        gui.startGUI();

    }

    public void startGUI() {
        frame = new JFrame("Subway Hunt");
        frame.setSize(500, 250);
        frame.setLocation(300,200);
        textArea = new JTextArea(10, 40);
        frame.getContentPane().add(BorderLayout.NORTH, textArea);
        // frame.getContentPane().add(BorderLayout.CENTER, textArea);

        ImageIcon icon = new ImageIcon("C:\\Users\\omara\\OneDrive\\Pictures\\shoppingCenter.png");
        JLabel label = new JLabel();
        label.setBounds(40,80,200,200);    
        label.setBackground(Color.gray); 
        label.setIcon(icon);

        frame.add(label);
        JButton walk = new JButton("walk");
        JButton take = new JButton("take");
        JButton drop = new JButton("drop");
        JButton look = new JButton("look");
        JButton back = new JButton("back");
        JButton help = new JButton("help");
        JButton quit = new JButton("quit");

        walk.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.append("\nWalk Button was Pressed");
                    frame.getContentPane().add(BorderLayout.SOUTH, walkGUI.walkPanel);
                    frame.getContentPane().remove(mainPanel);

                }
            });

        help.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.append(" help was Pressed");
                    ui.printHelp();
                }
            });

        back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.append(" back was Pressed");
                    // player.goBack();
                }
            });
        quit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.append(" quit was Pressed");
                    // player.quit();
                }
            });

        mainPanel.add(walk);
        mainPanel.add(take);
        mainPanel.add(drop);
        mainPanel.add(look);
        mainPanel.add(back);
        mainPanel.add(help);
        mainPanel.add(quit);
        frame.getContentPane().add(BorderLayout.SOUTH, mainPanel);

        frame.setVisible(true);
    }
}
