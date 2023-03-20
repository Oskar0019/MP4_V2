package Modes;

import Modes.ModeState;
import Pointer.Point;
import Shapes.Shape;
import container.ShapeContainer;

import java.util.List;

public class DeleteModeState implements ModeState {

    List<Shape> shapes;
    private ShapeContainer container;

    public DeleteModeState(List<Shape> shapes, ShapeContainer container) {
        this.shapes = shapes;
        this.container = container;
    }
    @Override
    public void pointerDown(Point point) {
        container.select(point);
        if (container.getSelected() != null) {
            shapes.remove(container.getSelected());
            container.setSelected(null);
            container.repaint();
        }

    }

    @Override
    public void pointerMoved(Point point) {
    }
}
