import java.util.HashMap;

public class UserManager {
    private HashMap<String, User> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, new User(username, password));
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Username already exists. Please choose another username.");
        }
    }

    public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }
}
