/*
BoundingBox.java
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

import com.google.common.annotations.VisibleForTesting;

/**
 * Stores an axis-aligned bounding box defined by two points.
 */
public record BoundingBox(double fromX, double fromY, double toX, double toY) {
    /**
     * Determines if the point is within this box.
     * @param x The X-coordinate.
     * @param y The Y-coordinate.
     * @return Whether the point is within this box.
     */
    public boolean isWithin(double x, double y) {
        return this.fromX < x && x < this.toX && this.fromY < y && y < this.toY;
    }

    /**
     * Validates the {@code BoundingBox}.<p>
     * {@code assertTrue(someBoundingBox.validate(), "Invalid bounding box!")}<p>
     * <b>DO NOT USE OUTSIDE OF TEST CODE!</b>
     * @return Whether the {@code BoundingBox} can be used.
     */
    @VisibleForTesting
    public boolean validate() {
        return this.toX > this.fromX && this.toY > this.fromY;
    }
}
