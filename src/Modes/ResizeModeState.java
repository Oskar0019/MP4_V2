package Modes;

import Modes.ModeState;
import Pointer.Point;
import container.ShapeContainer;

public class ResizeModeState implements ModeState {

    ShapeContainer container;

    public ResizeModeState(ShapeContainer container) {
        this.container = container;
    }

    @Override
    public void pointerDown(Point point) {
        container.select(point);
    }

    @Override
    public void pointerMoved(Point point) {
        container.getSelected().resizeTo(point);
        container.repaint();
    }
}
