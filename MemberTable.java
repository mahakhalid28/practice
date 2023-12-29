import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.*;

public class MemberTable extends TableView<Member> {

    private ArrayList<Member> members = new ArrayList<>();
    private TableColumn<Member, String> memberName = new TableColumn<Member, String>("Member Name");
    private TableColumn<Member, String> gender = new TableColumn<Member, String>("Gender");
    private TableColumn<Member, String> membershipType = new TableColumn<Member, String>("Membership type");
    private TableColumn<Member, String> dateOfBirth = new TableColumn<Member, String>(" Date Of Birth");

    public MemberTable(ArrayList<Member> members) {
        this.members = (ArrayList<Member>) members;
        this.getColumns().add(memberName);
        this.getColumns().add(gender);
        this.getColumns().add(membershipType);
        this.getColumns().add(dateOfBirth);

        this.setPrefWidth(500);
        displayMemberTable();
    }

    public void displayMemberTable() {
        memberName.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getMemberName());
        });
        gender.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getGender());
        });
        membershipType.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getMembershipType());
        });
        dateOfBirth.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(cellData.getValue().getDateOfBirth());
        });
        this.setItems(FXCollections.observableArrayList(members));

    }

    public void search(String query) {
        if (query.isEmpty()) {
            this.setItems(FXCollections.observableArrayList(members));
        } else {

            ArrayList<Member> filteredMembers = new ArrayList<>();
            for (Member m : members) {
                if (m.getMemberName().contains(query)) {
                    filteredMembers.add(m);
                }
            }
            this.setItems(FXCollections.observableArrayList(filteredMembers));
        }

    }

}
