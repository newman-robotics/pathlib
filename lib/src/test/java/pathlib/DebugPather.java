/*
DebugPather.java
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

package pathlib;

import java.util.Optional;

import javax.annotation.Nullable;

import io.github.newmanrobotics.pathlib.data.MutablePosition;
import io.github.newmanrobotics.pathlib.data.Position;
import io.github.newmanrobotics.pathlib.interfaces.Logger;
import io.github.newmanrobotics.pathlib.interfaces.Pather;

public class DebugPather implements Pather {
    private MutablePosition position = new MutablePosition();
    private Optional<Logger> logger = Optional.empty();

    public DebugPather() {}
    public DebugPather(Logger logger) {
        this.logger = Optional.of(logger);
    }

    @Override
    @Nullable
    public Position getPosition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPosition'");
    }

    @Override
    public void turnTo(double heading) {
        this.position.setHeading(heading);
    }

    @Override
    public void forwards(double distance) {
        this.position.translateForwards(distance);
        if (this.logger.isPresent())
            this.logger.get().info(String.format("Pather moved %d units forwards to new position %d, %d", distance, this.position.x(), this.position.y()));
    }

    @Override
    public boolean isWorking() {
        // The basic debug pather implementation only logs 
        return true;
    }
}
