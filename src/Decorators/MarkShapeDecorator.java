package Decorators;

import Pointer.Point;
import Shapes.Circle;
import Shapes.Shape;
import Shapes.Square;

import java.awt.Graphics;

import javax.swing.text.Position;

public class MarkShapeDecorator implements Shape
  {
  private Shape decoratee;
  public MarkShapeDecorator(Shape decoratee)
    {
    this.decoratee = decoratee;
    }
  @Override
  public void draw(Graphics g)
    {
    decoratee.draw(g);
    Point position = decoratee.getPosition();
    if(decoratee instanceof Circle) {
      int x = (int)(position.getX()-decoratee.getWidth()/2.0+0.5);
      int y = (int)(position.getY()-decoratee.getHeight()/2.0+0.5);
      g.fillOval(x,y,(int)(decoratee.getWidth()+0.5),(int)(decoratee.getHeight()+0.5));
    }
    else if(decoratee instanceof Square) {
      int x = (int)(position.getX()-(decoratee.getWidth()));
      int y = (int)(position.getY()-(decoratee.getHeight()));
      g.fillRect(x, y,(int)(decoratee.getWidth()*2), (int)(decoratee.getHeight()*2));
    }
  }
  
  @Override
  public Point getPosition()
    {
    return decoratee.getPosition();
    }
  @Override
  public double getWidth()
    {
    return decoratee.getWidth();
    }
  @Override
  public double getHeight()
    {
    return decoratee.getHeight();
    }
  @Override
  public boolean intersects(Point point)
    {
    return decoratee.intersects(point);
    }
  @Override
  public void moveTo(Point point)
    {
    decoratee.moveTo(point);
    }
  @Override
  public void move(double dx, double dy)
    {
    decoratee.move(dx, dy);
    }
  @Override
  public void resizeTo(Point point)
    {
    decoratee.resizeTo(point);
    }
  @Override
  public Shape peel()
    {
    return decoratee;
    }
  }
