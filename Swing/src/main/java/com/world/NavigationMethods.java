package com.world;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.Client.*;

public class NavigationMethods {
    public static void init() {
        north.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player = player.getCoordinateInDirection(Direction.NORTH);
                display.setIcon(player.getImage());
            }
        });

        east.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(player.imageURL);
                player = player.getCoordinateInDirection(Direction.EAST);
                System.out.println(player.imageURL);
                display.setIcon(player.getImage());
            }
        });

        south.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player = player.getCoordinateInDirection(Direction.SOUTH);
                display.setIcon(player.getImage());
            }
        });

        west.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player = player.getCoordinateInDirection(Direction.WEST);
                display.setIcon(player.getImage());
            }
        });
    }
}
