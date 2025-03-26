/*
Position.java
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
 * Stores a position.
 * @param x The X-coordinate of this {@code Position}. Must be Cartesian.
 * @param y The Y-coordinate of this {@code Position}. Must be Cartesian.
 * @param heading The heading of this {@code Position}. Must be in degrees and increase towards clockwise.
 */
public record Position(double x, double y, double heading) {
    
}
