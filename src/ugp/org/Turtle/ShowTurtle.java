package ugp.org.Turtle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public abstract class ShowTurtle extends Application {
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene sc1 = new Scene(root, 1500.0D, 1000.0D);
        stage.setScene(sc1);
        Turtle t = new Turtle(root, 750.0D, 500.0D);
        Program(t, stage);
        t.DoActions();
        stage.setTitle("JavaFx Turtle 1.0.5");
        stage.getIcons().add(new Image("ugp/org/Turtle/turtle.png"));
        stage.show();
    }

    protected abstract void Program(Turtle paramTurtle, Stage paramStage);
}
