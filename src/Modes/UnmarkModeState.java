package Modes;

import Modes.ModeState;
import Pointer.Point;
import Shapes.Shape;
import container.ShapeContainer;

import java.util.List;

public class UnmarkModeState implements ModeState {

    List<Shape> shapes;
    ShapeContainer container;

    public UnmarkModeState(List<Shape> shapes, ShapeContainer container) {
        this.shapes = shapes;
        this.container = container;
    }
    @Override
    public void pointerDown(Point point) {
        container.select(point);
        if(container.getSelected() != null)
        {
            Shape unmarkedShape = container.getSelected().peel();
            shapes.remove(container.getSelected());
            shapes.add(unmarkedShape);
            container.repaint();
        }
    }

    @Override
    public void pointerMoved(Point point) {

    }
}
