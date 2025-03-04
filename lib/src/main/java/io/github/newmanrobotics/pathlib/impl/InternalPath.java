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

import io.github.newmanrobotics.pathlib.Path;
import io.github.newmanrobotics.pathlib.interfaces.Logger;
import io.github.newmanrobotics.pathlib.interfaces.Pather;

public class InternalPath implements Path {
    private Pather target;
    private Logger logger;

    @Override
    public void connect(Pather target) {
        this.target = target;
    }

    @Override
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
