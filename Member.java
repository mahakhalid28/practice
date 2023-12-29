import java.util.ArrayList;

public class Member {
    private String memberName;
    private String gender;
    private String membershipType;
    private String dateOfBirth;

    public Member(String memberName, String gender, String membershipType, String dateOfBirth) {
        this.memberName = memberName;
        this.gender = gender;
        this.membershipType = membershipType;
        this.dateOfBirth = dateOfBirth;

    }

    public String getMemberName() {
        return this.memberName;
    }

    public void setMemberName(String name) {
        this.memberName = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;

    }

    public String getMembershipType() {
        return this.membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;

    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateofBirth) {
        this.dateOfBirth = dateofBirth;

    }

}
