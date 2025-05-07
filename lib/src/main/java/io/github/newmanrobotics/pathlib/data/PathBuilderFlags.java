/*
PathBuilderFlags.java
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
 * @param smooth Whether to generate a smooth path or not.
 * Smooth paths are disabled by default because most pathers are
 * not capable of smooth rotation without significant modification.
 * @param avoidBoxSize The size of the square box within which
 * the built path is guaranteed to never intersect with an object.
 */
public record PathBuilderFlags(boolean smooth, double avoidBoxSize) {
    /**
     * The default flags for {@code PathBuilder}s created without any flags.<p>
     * Values: <ul>
     * <li>{@code smooth = false}</li>
     * <li>{@code avoidBoxSize = 1.}</li>
     * </ul>
    */
    public static final PathBuilderFlags DEFAULT = new PathBuilderFlags(false, 1.);
}
