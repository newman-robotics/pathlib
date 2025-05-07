package io.github.newmanrobotics.pathlib.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import io.github.newmanrobotics.pathlib.World;
import io.github.newmanrobotics.pathlib.data.BoundingBox;
import io.github.newmanrobotics.pathlib.data.Vertex;

public class InternalWorld implements World {
    private List<BoundingBox> objects;

    /**
     * Prefer {@code World.create()} to {@code new InternalWorld()}.
     */
    public InternalWorld() {
        this.objects = new ArrayList<>();
    }

    public InternalWorld(List<BoundingBox> objects) {
        this.objects = objects;
    }
    
    @Override
    public void addObject(BoundingBox box) {
        this.objects.add(box);
    }

    @Override
    public World pad(double size) {
        List<BoundingBox> newObjects = new ArrayList<>(this.objects.size());
        for (BoundingBox box : this.objects) {
            Vertex from = new Vertex(box.fromX() - size, box.fromY() - size);
            Vertex to = new Vertex(box.toX() + size, box.toY() + size);
            BoundingBox newBox = new BoundingBox(from.x(), from.y(), to.x(), to.y());
            newObjects.add(newBox);
        }
        return World.create(newObjects);
    }

    @Override
    public List<BoundingBox> getObjects() {
        return this.objects;
    }

    @Override
    public Stream<BoundingBox> streamObjects() {
        return this.objects.stream();
    }
}
