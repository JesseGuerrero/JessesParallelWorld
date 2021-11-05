import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Test {
    public static JLabel display;
    public static JLabel playerList;
    public static JLabel chatbox;
    public static JButton north;
    public static JButton south;
    public static JButton west;
    public static JButton east;
    public static JButton yell;

    public static void populateGUI(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        playerList = new JLabel("<html>dsfgsxdfgdxsfg<br>test");
        playerList.setOpaque(true);
        playerList.setBackground(new Color(255, 255, 255, 100));

        display = new JLabel("", getMainImage("killbill.jpeg"), JLabel.CENTER);
        display.setHorizontalTextPosition(JLabel.LEFT);
        display.setVerticalTextPosition(JLabel.TOP);
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(0,0,2,0);
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy =0;
        pane.add(playerList, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        pane.add(display, c);

        north = new JButton("North");
        north.setPreferredSize(new Dimension(8, 8));
        c.insets = new Insets(0,2,0,2);
        c.ipady = 8;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(north, c);

        west = new JButton("West");
        west.setPreferredSize(new Dimension(8, 8));
        c.insets = new Insets(0,2,0,2);
        c.ipady = 8;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(west, c);

        east = new JButton("East");
        east.setPreferredSize(new Dimension(8, 8));
        c.insets = new Insets(0,2,0,2);
        c.ipady = 8;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 2;
        pane.add(east, c);

        south = new JButton("South");
        south.setPreferredSize(new Dimension(8, 8));
        c.insets = new Insets(2,2,2,2);
        c.ipady = 8;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 3;
        pane.add(south, c);

        yell = new JButton("Yell: Off");
        yell.setPreferredSize(new Dimension(8, 8));
        c.insets = new Insets(2,2,2,2);
        c.ipady = 8;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 3;
        pane.add(yell, c);


        JTextField input = new JTextField("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(2,0,0,0);  //top padding
        c.gridx = 0;       //aligned with button 2
        c.gridwidth = 3;   //3 columns wide
        c.gridy = 4;       //third row
        pane.add(input, c);
    }

    /**
     *
     * @param relPath: path from resources folder
     */
    private static ImageIcon getMainImage(String relPath) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(Test.class.getResource(relPath).toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        Image imgd = img.getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        return new ImageIcon(imgd);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        frame.setContentPane(panel);

        populateGUI(frame.getContentPane());
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
