package model;

import types.Coordinate;
import types.Direction;

public class Line {
    private Coordinate initialCoordinate;
    private Direction direction;

    public Line(Coordinate initialCoordinate, Direction direction) {
        this.initialCoordinate = initialCoordinate;
        this.direction = direction;
    }

    public Coordinate getCoordinate() {
        return this.initialCoordinate;
    }

    public void move() {
        this.initialCoordinate.move(this.direction);
    }
}
