package Modes;

import Modes.ModeState;
import Pointer.Point;
import Shapes.Circle;
import Shapes.Complex;
import Shapes.Square;
import Shapes.Shape;
import container.ShapeContainer;

import java.util.List;

public class InsertModeState implements ModeState {

    private List<Shape> shapes;
    private ShapeContainer container;
    private shapeType currentShape;

    public enum shapeType 
    {
        CIRCLE, RECTANGLE, COMPLEX
    };

    public InsertModeState(List<Shape> shapes, ShapeContainer container) {
        this.shapes = shapes;
        this.container = container;
        this.currentShape = container.getCurrentShapeType();
    }

    @Override
    public void pointerDown(Point point) {
        switch(container.getCurrentShapeType()) {
            case CIRCLE:
                shapes.add(new Circle(point, Math.random() * 50.0));
                break;
            case RECTANGLE:
                shapes.add(new Square(point, Math.random() * 50.0));
                break;
            case COMPLEX:
                shapes.add(new Complex(point, Math.random() * 50.0));
                break;
            default:
                throw new IllegalArgumentException("Invalid mode");
        }
        container.repaint();
    }

    @Override
    public void pointerMoved(Point point) {
    }
}
