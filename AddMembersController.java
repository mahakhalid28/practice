import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.skin.ToggleButtonSkin;
import javafx.scene.layout.VBox;

public class AddMembersController {
    private ArrayList<Member> members;
    ToggleGroup gender = new ToggleGroup();
    private TextField memberName = new TextField();

    private RadioButton male = new RadioButton("Male");

    private RadioButton female = new RadioButton("Female");
    private ComboBox<String> comboBox = new ComboBox<>();
    private DatePicker datePicker = new DatePicker();

    private Button saveButton = new Button("Save");
    private Button backButton = new Button("Back");

    private VBox root = new VBox();

    public AddMembersController(ArrayList<Member> members) {
        this.members = members;
        memberName.setPromptText("Enter member Name");
        male.setToggleGroup(gender);
        female.setToggleGroup(gender);
        comboBox.setPromptText(" Enter Membership type");
        datePicker.setPromptText("Date of Birth");

        comboBox.getItems().addAll("Standard", "Premium", "VIP");

        root.getChildren().addAll(memberName, male, female, comboBox, datePicker, saveButton, backButton);
        root.setPadding(new Insets(100, 100, 100, 100));
        root.setSpacing(10);
        saveButton.setOnAction((event) -> {
            onSaveButtonClicked(event);
        });

        backButton.setOnAction((event) -> {
            onBackButtonClicked(event);
        });

    }

    public void onSaveButtonClicked(ActionEvent event) {
        System.out.println("save button clicked");
        try {
            String Name = memberName.getText();

            if (Name.isEmpty() || gender.getSelectedToggle() == null
                    || comboBox.getSelectionModel().getSelectedItem() == null
                    || datePicker.getValue() == null) {
                Alert alert = new Alert(AlertType.ERROR, "Fill all the fields ");
                alert.show();
                return;

            }
            String selectedDate = datePicker.getValue().toString();
            RadioButton btn = (RadioButton) gender.getSelectedToggle();
            String selectedGender = btn.getText();
            System.out.printf("selected gender is %s/n", selectedGender);
            String selectedMembType = comboBox.getSelectionModel().getSelectedItem();
            System.out.printf("Member date of birth is %s", selectedDate);
            Member member = new Member(Name, selectedGender, selectedMembType, selectedDate);
            members.add(member);
            MemberFile.writeToFile("data.txt", member);
        } catch (NumberFormatException e) {
            System.out.println("please enter valid input");

        }

    }

    public void onBackButtonClicked(ActionEvent event) {
        System.out.println("Back button clicked");
        ManagerController managerController = new ManagerController(members);
        // Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(managerController.getScene());
        stage.show();

    }

    public VBox getRoot() {
        return root;
    }

    public Scene getScene() {
        return new Scene(root);
    }

}
