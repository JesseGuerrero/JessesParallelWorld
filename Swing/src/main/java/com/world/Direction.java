package com.world;

public enum Direction {
    NULL(0),
    NORTH(1),
    EAST(2),
    SOUTH(3),
    WEST(4);
    int dir;
    Direction(int dir) {
        this.dir = dir;
    }
}
