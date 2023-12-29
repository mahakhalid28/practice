import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;
import javafx.scene.Node;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.geometry.*;

public class ManagerController {

    private ArrayList<Member> members;

    private Button addNewMember = new Button("Add New Member");
    private Button ViewMembers = new Button("View Members");

    private HBox root = new HBox();

    public ManagerController(ArrayList<Member> members) {

        this.members = members;
        root.setSpacing(30);
        root.setPadding(new Insets(100, 100, 100, 100));
        Label title = new Label("Fitness Management System");
        root.getChildren().addAll(title, addNewMember, ViewMembers);

        addNewMember.setOnAction((event) -> {
            handleAddNewMember(event);
        });
        ViewMembers.setOnAction((event) -> {
            handleViewMembers(event);
        });

    }

    public void handleAddNewMember(ActionEvent event) {
        System.out.println("Add new member button clicked");
        AddMembersController addMembersController = new AddMembersController(members);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(addMembersController.getScene());
        stage.show();

    }

    public void handleViewMembers(ActionEvent event) {
        System.out.println("Add view members button clicked");
        MemberTableController memberTableController = new MemberTableController(members);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(memberTableController.getScene());
        stage.show();
    }

    public HBox getRoot() {
        return root;
    }

    public Scene getScene() {
        return new Scene(root);

    }

}
