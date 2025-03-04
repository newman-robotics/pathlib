/*
PathBuilder.java
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

package io.github.newmanrobotics.pathlib;

import io.github.newmanrobotics.pathlib.data.PathBuilderFlags;
import io.github.newmanrobotics.pathlib.data.Position;
import io.github.newmanrobotics.pathlib.impl.InternalPathBuilder;

public interface PathBuilder {
    public static PathBuilder create() {
        return new InternalPathBuilder();
    }

    public static PathBuilder create(PathBuilderFlags flags) {
        return new InternalPathBuilder(flags);
    }

    /**
     * This path will attempt to avoid all bounding boxes within the given world.
     * @param world The world to use.
     */
    public void setWorld(World world);

    /**
     * Adds the given target position.
     * @param target The target position to add. The {@code Pather} will be instructed to move to the coordinates and then rotate to the heading.
     */
    public void addTarget(Position target);

    /**
     * Builds the {@code Path}.
     * @return The {@code Path} that this {@code PathBuilder} describes.
     */
    public Path build();
}
