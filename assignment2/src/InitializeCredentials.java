import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class InitializeCredentials {

    private List<CredentialDB> listOfUsers;

    InitializeCredentials(){
        // Create an empty list to hold users
        listOfUsers = new ArrayList<>();

        // Add users to the list
        listOfUsers.add(new CredentialDB(0, "Admin", "Password1"));
        listOfUsers.add(new CredentialDB(1, "Vale.Vicky", "Password1"));
        listOfUsers.add(new CredentialDB(2, "Lane.Lois", "Password1"));
        listOfUsers.add(new CredentialDB(3, "Kent.Clark", "Password1"));
        listOfUsers.add(new CredentialDB(4, "Wayne.Bruce", "Password1"));
        listOfUsers.add(new CredentialDB(5, "Parker.Peter", "Password1"));
        listOfUsers.add(new CredentialDB(6, "Rogers.Steve", "Password1"));
        listOfUsers.add(new CredentialDB(7, "Luther.Lex", "Password1"));
        listOfUsers.add(new CredentialDB(8, "Osborn.Harry", "Password1"));
        listOfUsers.add(new CredentialDB(9, "Prince.Diana", "Password1"));
        listOfUsers.add(new CredentialDB(10, "Linda.Zoel", "Password1"));

    }

    static boolean CheckUser(String username, String password) {
        //Create.
        final InitializeCredentials newUserList = new InitializeCredentials();

        // Used to hold the instance of a user who successfully logged in
        CredentialDB loggedInUser = null;

        // Iterate through list of users to see if we have a match
        for (CredentialDB user : newUserList.listOfUsers) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    loggedInUser = user;

                    // when a user is found, "break" stops iterating through the list
                    break;
                }
            }
        }

        // if loggedInUser was changed from null, it was successful
        if (loggedInUser != null) {
            System.out.println("User successfully logged in: " + loggedInUser.getUsername());
            return true;
        } else {
            System.out.println("Invalid username/password combination" + username + password);
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        String greeting = "Hello";
        String username;
        String password;

        // Get user input
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("*** Welcome to the program ***\n");
        System.out.println(greeting);

        System.out.println("Please type your username :");
        username = br.readLine();
        System.out.println("Please type your password :");
        password = br.readLine();

        CheckUser(username, password);

    }

}
