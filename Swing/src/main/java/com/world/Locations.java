package com.world;

import com.world.Coordinate;
import com.world.Direction;

import java.util.HashMap;

public class Locations {
    public static HashMap<Integer, Coordinate> locations = new HashMap<>();
    static {
        Coordinate bedroom = new Coordinate(0, "bedroom.jpg");
        bedroom.setDirection(Direction.NORTH, 2);
        bedroom.setDirection(Direction.EAST, 3);
        bedroom.setDirection(Direction.SOUTH, 5);
        bedroom.setDirection(Direction.WEST, 1);

        Coordinate restroom = new Coordinate(1, "restroom.jpg");
        restroom.setDirection(Direction.EAST, 0);

        Coordinate patio = new Coordinate(2, "patio.jpg");
        patio.setDirection(Direction.SOUTH, 0);

        Coordinate closet = new Coordinate(3, "closet.jpg");
        closet.setDirection(Direction.NORTH, 0);

        Coordinate junk_room = new Coordinate(4, "junk_room.jpg");
        junk_room.setDirection(Direction.EAST, 0);

        Coordinate hall = new Coordinate(5, "hallway.jpg");
        hall.setDirection(Direction.NORTH, 0);
        hall.setDirection(Direction.WEST, 6);

        Coordinate kitchen = new Coordinate(6, "kitchen.jpg");
        kitchen.setDirection(Direction.EAST, 5);

        locations.put(0, bedroom);
        locations.put(1, restroom);
        locations.put(2, patio);
        locations.put(3, closet);
        locations.put(4, junk_room);
        locations.put(5, hall);
        locations.put(6, kitchen);
    }


}
