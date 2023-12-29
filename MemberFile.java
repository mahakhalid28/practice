import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

public class MemberFile {
    public static void writeToFile(String fileName, Member member) {
        if (!fileName.isEmpty()) {
            File file = new File(fileName);
            FileWriter fileWriter;
            BufferedWriter bufferedWriter;
            try {
                fileWriter = new FileWriter(file, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(String.format("%s,%s,%s,%s", member.getMemberName(), member.getGender(),
                        member.getMembershipType(), member.getDateOfBirth()));
                bufferedWriter.newLine();
                bufferedWriter.close();
                fileWriter.close();

            } catch (IOException e) {
                System.out.println("Error occurred while writing to file");
            }

        }

    }

    public static ArrayList<Member> readFromFile(String fileName) {

        ArrayList<Member> members = new ArrayList<Member>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {

                StringTokenizer stringTokenizer = new StringTokenizer(line);
                String name = stringTokenizer.nextToken(",");
                String gender = stringTokenizer.nextToken(",");
                String membershipType = stringTokenizer.nextToken(",");
                String dateOfBirth = stringTokenizer.nextToken(",");
                Member member = new Member(name, gender, membershipType, dateOfBirth);
                members.add(member);

            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {

        }
        return members;

    }

    public static ArrayList<User> readUsersFromFile(String fileName) {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader fileReader = new FileReader("file.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line);
                String username = stringTokenizer.nextToken(",");
                String password = stringTokenizer.nextToken(",");
                User user = new User(username, password);
                users.add(user);

            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {

        }
        // users.sort((u1, u2) -> {
        // if (u1.getUsername().length() < u2.getUsername().length())
        // return -1;
        // else if (u1.getUsername().length() > u2.getUsername().length())
        // return 1;
        // else
        // return 0;
        // });
        // Collections.sort(users);
        return users;
    }

}
