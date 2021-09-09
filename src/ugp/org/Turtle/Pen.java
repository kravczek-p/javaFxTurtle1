package ugp.org.Turtle;

import javafx.scene.Group;
import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Pen {
    protected double X;

    protected double Y;

    protected double pSize = 4.0D;

    protected boolean penDown = false;

    protected Color color = Color.BLACK;

    protected Effect effect;

    protected Group group;

    public Pen(double x, double y, Group group) {
        this.X = x;
        this.Y = y;
        this.group = group;
    }

    public double getX() {
        return this.X;
    }

    public double getY() {
        return this.Y;
    }

    public void setX(double x) {
        this.X = x;
    }

    public void setY(double y) {
        this.Y = y;
    }

    public double getPenSize() {
        return this.pSize;
    }

    public boolean isPenDown() {
        return this.penDown;
    }

    public Color getPenColor() {
        return this.color;
    }

    public void setPenSize(double pSize) {
        this.pSize = pSize;
    }

    public Effect getPenEffect() {
        return this.effect;
    }

    public void setPenEffect(Effect effect) {
        this.effect = effect;
    }

    public void penDown() {
        this.penDown = true;
    }

    public void penUp() {
        this.penDown = false;
    }

    public void setPenColor(Color color) {
        this.color = color;
    }

    public void PaintLine(double endX, double endY) {
        if (isPenDown()) {
            Line paint = new Line(getX(), getY(), endX, endY);
            paint.setStrokeWidth(getPenSize());
            paint.setStroke(getPenColor());
            paint.setEffect(getPenEffect());
            this.group.getChildren().add(paint);
        }
    }

    public void PaintPoint() {
        if (isPenDown()) {
            Rectangle paint = new Rectangle(getX() - getPenSize() / 2.0D, getY() - getPenSize() / 2.0D, getPenSize(), getPenSize());
            paint.setFill(getPenColor());
            paint.setEffect(getPenEffect());
            this.group.getChildren().add(paint);
        }
    }
}
