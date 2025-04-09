/*
InternalPath.java
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

import java.util.List;

import javax.annotation.Nullable;

import io.github.newmanrobotics.pathlib.Path;
import io.github.newmanrobotics.pathlib.data.Position;
import io.github.newmanrobotics.pathlib.interfaces.Logger;
import io.github.newmanrobotics.pathlib.interfaces.Pather;

public class InternalPath implements Path {
    private Pather pather = null;
    @Nullable
    private Logger logger = null;

    private List<Position> steps;
    private int stepIndex = 0;

    InternalPath(List<Position> steps) {
        this.steps = steps;
    }

    @Override
    public void connect(Pather pather) {
        this.pather = pather;
    }

    @Override
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public void step() {
        if (this.pather == null) {
            if (this.logger != null) this.logger.warn("Tried to step path, but did not attach device!");
            return;
        }
        if (this.pather.isWorking()) return;

        if (this.stepIndex == 0)
            this.pather.turnTo(Math.atan2(this.steps.get(0).y(), this.steps.get(0).x()));
        else
            this.pather.turnTo(Math.atan2(this.steps.get(this.stepIndex).y(), this.steps.get(this.stepIndex).x()));
    }
}
