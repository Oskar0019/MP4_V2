package Modes;

import Pointer.Point;

public interface ModeState {
    void pointerDown(Point point);
    void pointerMoved(Point point);
}
