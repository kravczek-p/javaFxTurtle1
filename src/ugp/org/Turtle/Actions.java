package ugp.org.Turtle;

public class Actions {
    public static void DrawT(Turtle t, int size) {
        t.Forward(size);
        t.Right(90.0D);
        t.Forward(size / 2);
        t.Back(size);
        t.Left(90.0D);
    }

    public static void DrawU(Turtle t, int size) {
        t.Right(180.0D);
        t.Forward(size);
        t.Left(45.0D);
        t.Forward(size / 2);
        t.Left(45.0D);
        t.Forward(size / 3);
        t.Left(45.0D);
        t.Forward(size / 2);
        t.Left(45.0D);
        t.Forward(size);
    }

    public static void DrawP(Turtle t, int size) {
        t.Left(90.0D);
        DrawU(t, size / 3);
        t.Left(90.0D);
        t.Forward(size);
        t.Left(180.0D);
    }

    public static void DrawR(Turtle t, int size) {
        t.Left(90.0D);
        DrawU(t, size / 3);
        t.Left(90.0D);
        t.Forward(size / 3 + 4);
        t.Left(90.0D);
        t.Forward(size / 4);
        t.Right(60.0D);
        t.Forward(size / 2);
        t.Back(size / 2);
        t.Left(60.0D);
        t.Back(size / 4);
        t.Right(90.0D);
        t.Forward(size / 2);
        t.Left(180.0D);
    }

    public static void DrawL(Turtle t, int size) {
        t.Right(90.0D);
        t.Forward(size / 2);
        t.Back(size / 2);
        t.Left(90.0D);
        t.Forward(size);
    }

    public static void DrawE(Turtle t, int size) {
        DrawL(t, size);
        t.Right(90.0D);
        t.Forward(size / 2);
        t.Back(size / 2);
        t.Right(90.0D);
        t.Forward(size / 2);
        t.Left(90.0D);
        t.Forward(size / 2);
        t.Left(90.0D);
    }

    public static void DrawH(Turtle t, int size) {
        t.Forward(size);
        t.Right(90.0D);
        t.penUp();
        t.Forward(size / 2);
        t.penDown();
        t.Right(90.0D);
        t.Forward(size);
        t.Back(size / 2);
        t.Right(90.0D);
        t.Forward(size / 2);
        t.Right(90.0D);
        t.Forward(size / 2);
    }

    public static void DrawI(Turtle t, int size) {
        t.Right(90.0D);
        t.Forward(size / 4);
        t.Back(size / 2);
        t.Forward(size / 4);
        t.Left(90.0D);
        t.Forward(size);
        t.Right(90.0D);
        t.Forward(size / 4);
        t.Back(size / 2);
        t.Forward(size / 4);
        t.Left(90.0D);
    }

    public static void DrawHashtag(Turtle t, int size) {
        t.Forward(size / 3);
        t.Right(90.0D);
        t.Back(size / 3);
        t.Forward(size);
        t.Back(size / 3);
        t.Left(90.0D);
        t.Back(size / 3);
        t.Forward(size + size / 3);
        t.Back(size / 3);
        t.Left(90.0D);
        t.Back(size / 3);
        t.Forward(size);
        t.Back(size / 3);
        t.Right(90.0D);
        t.Forward(size / 3);
        t.Back(size);
    }

    public static void DrawExclMark(Turtle t, int size) {
        double pSize = t.getPenSize();
        t.setPenSize(pSize * 2.0D);
        t.Forward(1);
        t.setPenSize(pSize);
        t.penUp();
        t.Forward(size / 4);
        t.penDown();
        t.Forward((int)(size / 1.25D));
    }

    public static void DrawRect(Turtle t, int width, int height) {
        t.Forward(height);
        t.Right(90.0D);
        t.Forward(width);
        t.Right(90.0D);
        t.Forward(height);
        t.Right(90.0D);
        t.Forward(width);
        t.Right(90.0D);
    }

    public static void DrawCircle(Turtle t, int size, int stepsMoreIsBetter) {
        for (int i = 0; i < stepsMoreIsBetter; i++) {
            t.Right((360 / stepsMoreIsBetter));
            t.Forward(size / stepsMoreIsBetter);
        }
    }
}
