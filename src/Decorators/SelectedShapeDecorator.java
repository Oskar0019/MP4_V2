package Decorators;

import Pointer.Point;
import Shapes.Shape;

import java.awt.Graphics;
import java.awt.Color;

public class SelectedShapeDecorator implements Shape {

    private Shapes.Shape decoratee;

    public SelectedShapeDecorator(Shapes.Shape decoratee) {
        this.decoratee = decoratee;
    }
    @Override
    public void draw(Graphics g) {
        decoratee.draw(g);
        Point position = decoratee.getPosition();
        int x = (int) (position.getX() - decoratee.getWidth() / 2.0 + 0.5);
        int y = (int) (position.getY() - decoratee.getHeight() / 2.0 + 0.5);
        int w = (int)(decoratee.getWidth()+0.5);
        int h = (int)(decoratee.getHeight()+0.5);
        g.drawLine(x, y + h/2, x + w, y + h/2);
        g.drawLine(x + w/2, y, x + w/2, y + h);
    }

    @Override
    public Pointer.Point getPosition() {
        return decoratee.getPosition();
    }

    @Override
    public double getWidth() {
        return decoratee.getWidth();
    }

    @Override
    public double getHeight() {
        return decoratee.getHeight();
    }

    @Override
    public boolean intersects(Point point) {
        return decoratee.intersects(point);
    }

    @Override
    public void moveTo(Point point) {
        decoratee.moveTo(point);
    }

    @Override
    public void move(double dx, double dy) {
        decoratee.move(dx, dy);
    }

    @Override
    public void resizeTo(Point point) {
        decoratee.resizeTo(point);
    }

    @Override
    public Shape peel() {
        return decoratee;
    }
}
