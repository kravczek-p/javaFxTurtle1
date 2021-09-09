package ugp.org.Turtle;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Turtle extends Pen {
    protected Image turtle = new Image("ugp/org/Turtle/turtle.png");

    protected int angle = 0;

    protected int speed = 8;

    protected Rectangle sprite;

    protected List<Runnable> actions = new CopyOnWriteArrayList<>();

    private double lastX;

    private double lastY;

    protected AnimationTimer loop = new AnimationTimer() {
        public void handle(long now) {
            if (!Turtle.this.isSleeping()) {
                Turtle.this.PaintLine(Turtle.this.lastX, Turtle.this.lastY);
                Turtle.this.sprite.toFront();
                Turtle.this.lastX = Turtle.this.X;
                Turtle.this.lastY = Turtle.this.Y;
            }
            Turtle.this.sprite.setX(Turtle.this.X - 10.0D);
            Turtle.this.sprite.setY(Turtle.this.Y - 10.0D);
            Turtle.this.sprite.setRotate(Turtle.this.angle);
            Turtle.this.sprite.setEffect(new DropShadow(5.0D, Turtle.this.color));
        }
    };

    public Turtle(Group g, double x, double y) {
        super(x, y, null);
        this.lastX = x;
        this.lastY = y;
        (this.group = g).getChildren().add(this.sprite = new Rectangle(20.0D, 20.0D));
        this.sprite.setFill(new ImagePattern(this.turtle));
        this.loop.start();
        penDown();
    }

    public void penUp() {
        Action(() -> super.penUp());
    }

    public void penDown() {
        Action(() -> super.penDown());
    }

    public void setPenColor(Color newColor) {
        Action(() -> super.setPenColor(paramColor));
    }

    public void setPenEffect(Effect effect) {
        Action(() -> super.setPenEffect(paramEffect));
    }

    public void setPenSize(double newSize) {
        Action(() -> super.setPenSize(paramDouble));
    }

    public void setX(double newX) {
        Action(() -> super.setX(paramDouble));
    }

    public void setY(double newY) {
        Action(() -> super.setY(paramDouble));
    }

    public void setSpeed(int newSpeed) {
        Action(() -> {

        });
    }

    public void setAngle(int newAngleInDegrees) {
        Action(() -> {

        });
    }

    public void TeleportTo(double newX, double newY) {
        Action(() -> {
            super.setX(paramDouble1);
            super.setY(paramDouble2);
        });
    }

    public void AddAngle(int degrees) {
        if (degrees > 0) {
            Right(degrees);
        } else {
            Left(Math.abs(degrees));
        }
    }

    public void Right(double degrees) {
        Action(() -> {
            for (int y = 0; y < paramDouble; y++) {
                this.angle++;
                try {
                    Thread.sleep((11 - this.speed));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void Left(double degrees) {
        Action(() -> {
            for (int y = 0; y < paramDouble; y++) {
                this.angle--;
                try {
                    Thread.sleep((11 - this.speed));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void Forward(int distance) {
        Action(() -> {
            for (int y = 0; y <= paramInt; y++) {
                this.X += Math.sin(Math.toRadians(this.angle));
                this.Y -= Math.cos(Math.toRadians(this.angle));
                try {
                    Thread.sleep((11 - this.speed));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void Back(int distance) {
        Action(() -> {
            for (int y = 0; y <= paramInt; y++) {
                this.X -= Math.sin(Math.toRadians(this.angle));
                this.Y += Math.cos(Math.toRadians(this.angle));
                try {
                    Thread.sleep((11 - this.speed));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void Sleep(int millis) {
        Action(() -> {
            try {
                Thread.sleep(paramInt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void Action(Runnable action) {
        this.actions.add(action);
    }

    public void DoActions() {
        (new Thread(() -> {
            for (Runnable r : getActions()) {
                try {
                    Thread.sleep(40L);
                    r.run();
                    this.actions.remove(r);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        })).start();
    }

    public List<Runnable> getActions() {
        return this.actions;
    }

    public boolean isSleeping() {
        return (this.lastX == this.X && this.lastY == this.Y);
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getAngle() {
        return this.angle;
    }
}
