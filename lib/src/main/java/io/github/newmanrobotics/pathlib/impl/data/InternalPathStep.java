package io.github.newmanrobotics.pathlib.impl.data;

import io.github.newmanrobotics.pathlib.data.Position;

public record InternalPathStep(Position target, double heading) {}
