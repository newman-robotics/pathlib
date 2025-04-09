/*
InternalPathBuilder.java
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

package io.github.newmanrobotics.pathlib.impl;

import java.util.ArrayList;
import java.util.List;

import io.github.newmanrobotics.pathlib.Path;
import io.github.newmanrobotics.pathlib.PathBuilder;
import io.github.newmanrobotics.pathlib.World;
import io.github.newmanrobotics.pathlib.data.PathBuilderFlags;
import io.github.newmanrobotics.pathlib.data.Position;

public class InternalPathBuilder implements PathBuilder {
    private PathBuilderFlags flags;
    private List<Position> targets = new ArrayList<>();
    private World world;

    public InternalPathBuilder() {
        this.flags = PathBuilderFlags.DEFAULT;
    }

    public InternalPathBuilder(PathBuilderFlags flags) {
        this.flags = flags;
    }

    @Override
    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public PathBuilder addTarget(Position target) {
        this.targets.add(target);
        return this;
    }

    @Override
    public Path build() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'build'");
    }
}
