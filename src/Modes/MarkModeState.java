package Modes;

import Decorators.MarkShapeDecorator;
import Decorators.SelectedShapeDecorator;
import Modes.ModeState;
import Pointer.Point;
import Shapes.Shape;
import container.ShapeContainer;

import java.util.List;

public class MarkModeState implements ModeState {

    List<Shape> shapes;
    ShapeContainer container;

    public MarkModeState(List<Shape> shapes, ShapeContainer container) {
        this.shapes = shapes;
        this.container = container;
    }
    @Override
    public void pointerDown(Point point) {
        container.select(point);
        if(container.getSelected() != null)
        {
            Shape markedShape = new SelectedShapeDecorator(container.getSelected().peel());
            shapes.remove(container.getSelected());
            shapes.add(markedShape);
            container.repaint();
        }
    }

    @Override
    public void pointerMoved(Point point) {

    }
}
