package Modes;

import Modes.ModeState;
import Pointer.Point;
import container.ShapeContainer;

public class MoveModeState implements ModeState {

    private ShapeContainer container;
    public MoveModeState(ShapeContainer container) {
        this.container = container;
    }
    @Override
    public void pointerDown(Point point) {
        container.select(point);
    }

    @Override
    public void pointerMoved(Point point) {
        container.getSelected().moveTo(point);
        container.repaint();
    }
}
