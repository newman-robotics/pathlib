/*
Path.java
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

import io.github.newmanrobotics.pathlib.interfaces.Logger;
import io.github.newmanrobotics.pathlib.interfaces.Pather;

public interface Path {
    /**
     * Instructs this {@code Path} to send commands to the target.
     * @param target The target. Will be ordered to move by this object.
     */
    public void connect(Pather target);

    /**
     * Sets the {@code Logger} of this {@code Path} to the target.
     * @param logger The logger.
     */
    public void setLogger(Logger logger);
}
