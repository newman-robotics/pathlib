/*
MutablePosition.java
Copyright (C) 2025 Owen Kelley

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

package io.github.newmanrobotics.pathlib.data;

/**
 * Stores a mutable (that is, modifiable) position.
 */
public class MutablePosition {
    private double x, y, heading;

    public MutablePosition() {
        this(0, 0, 0);
    }

    /**
     * Constructs a MutablePosition.
     * @param x The initial x of the position.
     * @param y The initial y of the position.
     * @param heading The initial heading of the position.
     */
    public MutablePosition(double x, double y, double heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    public double x() {return this.x;}
    public double y() {return this.y;}
    public double heading() {return this.heading;}

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setHeading(double heading) {
        this.heading = heading;
    }

    /**
     * Translates this {@code MutablePosition} {@code distance} units forwards in-place.
     * @param distance The distancce to move this position forwards. Can be negative, in which case the position translates backwards instead.
     */
    public void translateForwards(double distance) {
        double xNormal = Math.sin(this.heading);
        double yNormal = Math.cos(this.heading);
        this.x += xNormal * distance;
        this.y += yNormal * distance;
    }

    /**
     * Converts this {@code MutablePosition} to an immutable representation.
     * @return A {@code Position}.
     */
    public Position toImmutable() {
        return new Position(this.x, this.y, this.heading);
    }
}