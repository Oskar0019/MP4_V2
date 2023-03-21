package container;

import Decorators.SelectedShapeDecorator;
import Modes.*;
import Modes.InsertModeState.shapeType;
import Pointer.MouseHandler;
import Pointer.Point;
import Pointer.Pointable;
import Shapes.Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class ShapeContainer extends JPanel implements Pointable
  {
  private static final long serialVersionUID = 1L;
  private List<Shape>       shapes           = new LinkedList<Shape>();
  private shapeType currentShape = shapeType.CIRCLE;


  public enum Mode
    {
    INSERT, MOVE, DELETE, MARK, UNMARK, RESIZE
    };

  private ModeState currentMode = new InsertModeState(shapes, this);
  private Shape selected;
  
  public ShapeContainer()
    {
    super();
    MouseHandler mouseHandler = new MouseHandler(this);
    this.addMouseListener(mouseHandler);
    this.addMouseMotionListener(mouseHandler);
    this.setBackground(Color.white);
    }
  
  public void addShape(Shape shape)
    {
    shapes.add(shape);
    }
  
  public void setCurrentShapeType(shapeType currentShape) {
    this.currentShape = currentShape;
  }

  public shapeType getCurrentShapeType() {
    return currentShape;
  }


  public void paintComponent(Graphics g) // anropas av Swing när det är dags att
                                         // rendera
    {
    super.paintComponent(g);

    for (Shape shape : shapes)
      shape.draw(g);

    }

  public void select(Point point)
    {
    for (Shape shape : shapes)
      {
      if (shape.intersects(point))
        {
        selected = shape;
        return;
        }
      }
    }

    public Shape getSelected() {
      return selected;
    }

    public void setSelected(Shape selected) {
      this.selected = selected;
    }

  public void pointerDown(Point point)
    {
    currentMode.pointerDown(point);
    }

  public void pointerUp(Point point)
    {
    selected = null;
    }

  public void pointerMoved(Point point, boolean pointerDown)
    {
    if (selected != null && pointerDown) {
      currentMode.pointerMoved(point);
    }
    }

  public void setMode(Mode mode)
    {
    switch (mode) {
      case INSERT:
        currentMode = new InsertModeState(shapes, this);
        break;
      case MOVE:
        currentMode = new MoveModeState(this);
        break;
      case DELETE:
        currentMode = new DeleteModeState(shapes, this);
        break;
      case MARK:
        currentMode = new MarkModeState(shapes, this);
        break;
      case UNMARK:
        currentMode = new UnmarkModeState(shapes, this);
        break;
      case RESIZE:
        currentMode = new ResizeModeState(this);
        break;
      default:
        throw new IllegalArgumentException("Invalid mode");
    }
    }
  }
