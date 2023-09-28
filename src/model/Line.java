package model;

import types.Coordinate;
import types.Direction;

public class Line {
    private Coordinate actualCoordinate;
    private Direction direction;

    public Line(Coordinate initialCoordinate, Direction direction) {
        this.actualCoordinate = initialCoordinate;
        this.direction = direction;
    }

    public Coordinate getCoordinate() {
        return this.actualCoordinate;
    }

    public void next() {
        this.actualCoordinate.move(this.direction);
    }
}
