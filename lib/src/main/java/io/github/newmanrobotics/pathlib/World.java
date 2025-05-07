/*
World.java
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

import java.util.List;
import java.util.stream.Stream;

import io.github.newmanrobotics.pathlib.data.BoundingBox;
import io.github.newmanrobotics.pathlib.impl.InternalWorld;

public interface World {
    /**
     * Creates a new {@code World} instance.
     * @return A fresh {@code World} instance.
     * 
     * @implNote This method just calls {@code new InternalWorld()} by default.
     * However, it's better to use this method instead of that one because
     * of convention.
     */
    public static World create() {
        return new InternalWorld();
    }

    /**
     * Creates a new {@code World} instance from the given objects.
     * @return A fresh {@code World} instance including the given objects.
     * 
     * @implNote This method just calls {@code new InternalWorld(objects)} by default.
     * However, it's better to use this method instead of that one because
     * of convention.
     */
    public static World create(List<BoundingBox> objects) {
        return new InternalWorld(objects);
    }
    
    /**
     * Adds an object to the world. Paths using this world will attempt to avoid this object.
     * @param box 
     */
    public void addObject(BoundingBox box);

    public List<BoundingBox> getObjects();
    public Stream<BoundingBox> streamObjects();

    /**
     * Pads every {@code BoundingBox} within this {@code World} by {@code size}.
     * @param size The size to pad by. Essentially, all points are moved away from the
     * centre of the box by {@code size} units in each direction.
     * @implSpec This should not be an in-place operation.
     */
    public World pad(double size);
}
