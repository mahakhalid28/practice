import java.util.ArrayList;

import org.w3c.dom.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.geometry.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
    private ArrayList<Member> members;

    private Button loginbtn = new Button("Login");
    private TextField usernameField = new TextField("username");
    private TextField PasswordField = new TextField("Password");
    private BorderPane root = new BorderPane();
    private VBox centerBox = new VBox();

    public MainController(ArrayList<Member> members) {
        this.members = members;
        Label label = new Label("Fitness Management System");
        centerBox.getChildren().add(label);
        centerBox.setMaxHeight(Double.MAX_VALUE);
        centerBox.setMaxWidth(300);
        root.setCenter(centerBox);

        // set Vbox elements
        usernameField.setPromptText("username");
        PasswordField.setPromptText("Password");
        centerBox.setSpacing(10);
        centerBox.setPadding(new Insets(100, 100, 100, 100));
        centerBox.getChildren().add(usernameField);
        centerBox.getChildren().add(PasswordField);
        centerBox.getChildren().add(loginbtn);
        loginbtn.setOnAction((event) -> {
            OnLoginButton(event);
        });

    }

    public void OnLoginButton(ActionEvent event) {
        String username = usernameField.getText();
        String password = PasswordField.getText();
        User user = new User(username, password);
        ArrayList<User> users = MemberFile.readUsersFromFile("file.txt");
        for (User u : users) {
            if (user.equals(u)) {
                System.out.println("Success");

                // show manager Controller
                ManagerController managerController = new ManagerController(members);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(managerController.getScene());
                stage.show();
                return;
            }
        }
        Alert alert = new Alert(AlertType.ERROR, "Username or password incorrect");
        alert.show();

    }

}
