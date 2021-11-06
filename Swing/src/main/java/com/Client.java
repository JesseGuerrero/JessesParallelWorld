package com;

import com.world.Coordinate;
import com.world.NavigationMethods;

import javax.swing.*;
import java.awt.*;

import static com.world.Locations.*;

public class Client {
    public static JFrame frame;
    public static JPanel panel;
    public static JLabel display;
    public static JLabel playerList;
    public static JLabel chatbox;
    public static JButton north;
    public static JButton south;
    public static JButton west;
    public static JButton east;
    public static JButton yell;
    public static Coordinate player;

    public static void main(String[] args) {

        frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridBagLayout());
        frame.setContentPane(panel);

        player = locations.get(0);
        GUISetup.init();
        NavigationMethods.init();

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
