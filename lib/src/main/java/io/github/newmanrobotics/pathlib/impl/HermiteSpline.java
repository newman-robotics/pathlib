/*
HermiteSpline.java
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

/**
 * A simple and likely problematic Hermite spline implementation.
 * See https://www.cs.cornell.edu/courses/cs4620/2013fa/lectures/16spline-curves.pdf
 * for details on the Hermite spline algorithm (page 35).
 * 
 * @implNote Use {@code HermiteSpline.Builder} to create splines.
 */
public class HermiteSpline {
    private List<Piece> pieces;

    private HermiteSpline(List<Piece> pieces) {
        this.pieces = pieces;
    }

    /**
     * Samples the spline at the given time.
     * @param time The time to sample the spline at. Must be between 0
     * and the return value of {@code getMaxTime()}.
     * @return The spline's value at the given time.
     * 
     * @implNote The speed of the spline's output changing might change
     * dramatically at integer multiples of {@code time}. This is because,
     * currently, there is no way for us to determine how long each spline
     * piece is. I don't even know whether each spline piece changes its
     * output at a constant rate.
     */
    public double sample(double time) {
        assert time >= 0 && time <= this.getMaxTime();

        double idx = Math.floor(time);
        return this.pieces.get((int)idx).sample(time - idx);
    }

    /**
     * Gets the maximum run time for this spline.
     * @return The maximum value that can be inserted into {@code sample()}
     * before an {@code AssertionError} occurs.
     */
    public double getMaxTime() {
        return (double)this.pieces.size();
    }

    /**
     * A single piece of the spline between two points.
     * 
     * @implNote A cubic that only samples in one dimension.
     */
    private class Piece {
        private double coeff0, coeff1, coeff2, coeff3;

        public Piece(double pos0, double pos1, double tan0, double tan1) {
            this.coeff0 = pos0;
            this.coeff1 = tan0;
            this.coeff2 = 3 * pos1 - 3 * pos0 - 2 * tan0 - tan1;
            this.coeff3 = 2 * pos0 - 2 * pos1 + tan0 + tan1;
        }

        /**
         * Sample the spline piece.
         * @param time The time at which to sample the spline piece.
         * @return The value of the spline piece at the given time.
         */
        public double sample(double time) {
            return this.coeff0 + this.coeff1 * time + this.coeff2 * time * time + this.coeff3 * time * time * time;
        }
    }

    /**
     * Hermite spline builder.
     */
    public class Builder {
        private List<Double> positions;
        private List<Double> derivatives;

        public Builder() {
            this.positions = new ArrayList<>();
            this.derivatives = new ArrayList<>();
        }

        /**
         * Adds a point to the spline.
         * @param position The position of the point.
         * @param derivative The derivative, slope, or tangent of the point.
         */
        public void addPoint(double position, double derivative) {
            this.positions.add(position);
            this.derivatives.add(derivative);
        }

        /**
         * Builds the Hermite spline.
         * @return A ready-to-be-sampled Hermite spline.
         */
        public HermiteSpline build() {
            List<Piece> pieces = new ArrayList<>();

            for (int i = 0; i < this.positions.size() - 1; ++i) {
                pieces.add(new Piece(this.positions.get(i), this.positions.get(i + 1), this.derivatives.get(i), this.derivatives.get(i + 1)));
            }

            return new HermiteSpline(pieces);
        }
    }
}
