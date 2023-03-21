package Decorators;

import Pointer.Point;
import Shapes.Circle;
import Shapes.Complex;
import Shapes.Shape;
import Shapes.Square;

import java.awt.Graphics;

import javax.swing.text.Position;

public class MarkShapeDecorator implements Shape {
  private Shape decoratee;

  public MarkShapeDecorator(Shape decoratee) {
    this.decoratee = decoratee;
  }

  @Override
  public void draw(Graphics g) {
    decoratee.draw(g);
    Point position = decoratee.getPosition();
    if (decoratee instanceof Circle) {
      int x = (int) (position.getX() - decoratee.getWidth() / 2.0 + 0.5);
      int y = (int) (position.getY() - decoratee.getHeight() / 2.0 + 0.5);
      g.fillOval(x, y, (int) (decoratee.getWidth() + 0.5), (int) (decoratee.getHeight() + 0.5));
    } else if (decoratee instanceof Square) {
      int x = (int) (0.5 + position.getX() - decoratee.getWidth());
      int y = (int) (0.5 + position.getY() - decoratee.getHeight());
      g.fillRect(x, y, (int) (0.5 + 2 * decoratee.getWidth()), (int) (0.5 + 2 * decoratee.getHeight()));
    } else if (decoratee instanceof Complex) {
      Complex complexDecoratee = (Complex) decoratee;

      Point circlePosition = complexDecoratee.getCircle().getPosition();
      int circleX = (int) (circlePosition.getX() - complexDecoratee.getCircle().getWidth() / 2.0 + 0.5);
      int circleY = (int) (circlePosition.getY() - complexDecoratee.getCircle().getHeight() / 2.0 + 0.5);
      g.fillOval(circleX, circleY, (int) (complexDecoratee.getCircle().getWidth() + 0.5),
          (int) (complexDecoratee.getCircle().getHeight() + 0.5));

      Point squarePosition = complexDecoratee.getSquare().getPosition();
      int squareX = (int) (0.5 + squarePosition.getX() - complexDecoratee.getSquare().getWidth());
      int squareY = (int) (0.5 + squarePosition.getY() - complexDecoratee.getSquare().getHeight());
      g.fillRect(squareX, squareY, (int) (0.5 + 2 * complexDecoratee.getSquare().getWidth()),
          (int) (0.5 + 2 * complexDecoratee.getSquare().getHeight()));
    }
  }

  @Override
  public Point getPosition() {
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
