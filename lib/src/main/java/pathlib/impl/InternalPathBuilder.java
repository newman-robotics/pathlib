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

package pathlib.impl;

import pathlib.Path;
import pathlib.PathBuilder;
import pathlib.World;
import pathlib.data.PathBuilderFlags;
import pathlib.data.Position;

public class InternalPathBuilder implements PathBuilder {
    private PathBuilderFlags flags;
    private World world;

    public InternalPathBuilder() {
        this.flags = PathBuilderFlags.DEFAULT;
    }

    public InternalPathBuilder(PathBuilderFlags flags) {
        this.flags = flags;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public void addTarget(Position target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTarget'");
    }

    @Override
    public Path build() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'build'");
    }
}
