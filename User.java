public class User implements Comparable {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(User u) {
        return this.username.equals(u.username) && this.password.equals(u.password);
    }

    public int compareTo(Object obj) {
        if (obj instanceof User) {
            User u = (User) obj;
            if (this.username.length() < u.username.length()) {
                return -1;
            } else if (this.username.length() > u.username.length()) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }

}
