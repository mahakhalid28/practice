import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    private static ArrayList<Member> members = MemberFile.readFromFile("data.txt");

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        ManagerController manager = new ManagerController(members);
        StackPane root = new StackPane();
        primaryStage.setTitle("Fitness Management System");
        primaryStage.setScene(new Scene(manager
                .getRoot(), 800, 600));

        primaryStage.show();
    }
}
