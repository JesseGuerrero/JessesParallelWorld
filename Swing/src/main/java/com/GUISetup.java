package com;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.Client.*;
import static com.Utils.*;

public class GUISetup {
    public static void init() {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        playerList = new JLabel("<html>dsfgsxdfgdxsfg<br>test");
        playerList.setOpaque(true);
        playerList.setBackground(new Color(255, 255, 255, 100));

        display = new JLabel("", getMainImage("bedroom.jpg"), JLabel.CENTER);
        display.setHorizontalTextPosition(JLabel.LEFT);
        display.setVerticalTextPosition(JLabel.TOP);
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(0,0,2,0);
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy =0;
        panel.add(playerList, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(display, c);

        north = new JButton("North");
        north.setPreferredSize(new Dimension(8, 8));
        c.insets = new Insets(0,2,0,2);
        c.ipady = 8;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        panel.add(north, c);

        west = new JButton("West");
        west.setPreferredSize(new Dimension(8, 8));
        c.insets = new Insets(0,2,0,2);
        c.ipady = 8;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        panel.add(west, c);

        east = new JButton("East");
        east.setPreferredSize(new Dimension(8, 8));
        c.insets = new Insets(0,2,0,2);
        c.ipady = 8;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 2;
        panel.add(east, c);

        south = new JButton("South");
        south.setPreferredSize(new Dimension(8, 8));
        c.insets = new Insets(2,2,2,2);
        c.ipady = 8;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 3;
        panel.add(south, c);

        yell = new JButton("Yell: Off");
        yell.setPreferredSize(new Dimension(8, 8));
        c.insets = new Insets(2,2,2,2);
        c.ipady = 8;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 3;
        panel.add(yell, c);


        JTextField input = new JTextField("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(2,0,0,0);  //top padding
        c.gridx = 0;       //aligned with button 2
        c.gridwidth = 3;   //3 columns wide
        c.gridy = 4;       //third row
        panel.add(input, c);
    }


}
