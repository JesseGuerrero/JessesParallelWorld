package com.world;

import javax.swing.*;

import java.util.HashMap;

import static com.Client.player;
import static com.Utils.getMainImage;
import static com.Utils.playWavSound;
import static com.world.Locations.locations;

public class Coordinate {
    int coordinate;
    String imageURL;
    HashMap<Direction, Integer> exits = new HashMap<>();

    public Coordinate(int coordinate, String imageURL) {
        this.coordinate = coordinate;
        this.imageURL = imageURL;
    }

    public ImageIcon getImage() {
        return getMainImage(imageURL);
    }

    public void setDirection(Direction dir, int coordinateId) {
        exits.put(dir, coordinateId);
    }

    public Coordinate getCoordinateInDirection(Direction dir) {
        try {
            Coordinate newLoc = locations.get(exits.get(dir));
            if(newLoc == null)
                throw new NullPointerException("Location doesn't exist");
            else {
                return newLoc;
            }
        } catch(NullPointerException ex) {
            playWavSound("noexit.wav");
        }
        return this;
    }

    /**
     *
     * @return north coordinate ID
     */
    public int getNorth() {
        return exits.get(Direction.NORTH);
    }

    public int getEast() {
        return exits.get(Direction.EAST);
    }

    public int getSouth() {
        return exits.get(Direction.SOUTH);
    }

    public int getWest() {
        return exits.get(Direction.WEST);
    }
}
