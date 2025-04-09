/*
Pather.java
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

package io.github.newmanrobotics.pathlib.interfaces;

import javax.annotation.Nullable;

import io.github.newmanrobotics.pathlib.data.Position;

/**
 * A {@code Pather} is some object which is capable of pathing using PathLib.
 */
public interface Pather {
    /**
     * Gets the position of the pather.
     * @return The position of the pather, or {@code null} if no position could be found.
     * @see Position
     */
    @Nullable
    public Position getPosition();

    /**
     * Turns the pather towards the given heading.
     * @param heading The heading to turn to, in degrees. Zero is the direction in which the {@code Pather} was facing
     * when the path was instantiated.
     */
    public void turnTo(double heading);

    /**
     * Moves the pather forwards for the given distance.
     * @param distance The distance to move in. A negative distance results in undefined behaviour,
     * although ideally the pather should stop or issue a warning and do nothing.
     */
    public void forwards(double distance);

    /**
     * Determines whether the pather is doing something and incapable of receiving new instructions.
     * @return See above.
     */
    public boolean isWorking();
}
