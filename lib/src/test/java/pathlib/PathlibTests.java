/*
PathlibTests.java
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

import org.junit.jupiter.api.Test;

import io.github.newmanrobotics.pathlib.Path;
import io.github.newmanrobotics.pathlib.PathBuilder;
import io.github.newmanrobotics.pathlib.data.Position;
import io.github.newmanrobotics.pathlib.impl.HermiteSpline;

import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;

public class PathlibTests {
    @Disabled("Just a test for JUnit; only to be used if it's freaking out.")
    @Test void testJUnit() {
        // Done this way so that it's a bit more obvious what the test is actually doing.
        assertNotNull(new String("test string"), "This should be successful");
        assertNotNull(null, "This should fail");
    }

    @Test void testBasicPath() {
        BasicLogger logger = new BasicLogger();
        DebugPather pather = new DebugPather(logger);

        Path path = PathBuilder.create()
                                .addTarget(new Position(5, 0, 0))
                                .addTarget(new Position(5, 3, 0))
                                .build();
        path.connect(pather);
        path.setLogger(logger);

        path.step();
        pather.assertPos(new Position(5, 0, 0));

        path.step();
        pather.assertPos(new Position(5, 3, Double.NaN));
    }

    @Test void testSpline() {
        HermiteSpline spline = new HermiteSpline.Builder()
                                .addPoint(0, 0)
                                .addPoint(1, 0)
                                .addPoint(0, 0)
                                .build();

        assertEquals(0, spline.sample(0));
        assertEquals(0.5, spline.sample(0.5));
        assertEquals(1, spline.sample(1));
        assertEquals(0.5, spline.sample(1.5));
        assertEquals(0, spline.sample(2));
    }
}
