package Modes;

import Modes.ModeState;
import Pointer.Point;
import Shapes.Circle;
import Shapes.Shape;
import container.ShapeContainer;

import java.util.List;

public class InsertModeState implements ModeState {
    private List<Shape> shapes;
    private ShapeContainer container;

    public InsertModeState(List<Shape> shapes, ShapeContainer container) {
        this.shapes = shapes;
        this.container = container;
    }
    @Override
    public void pointerDown(Point point) {
        shapes.add(new Circle(point, Math.random() * 50.0));
        container.repaint();
    }

    @Override
    public void pointerMoved(Point point) {
    }
}
