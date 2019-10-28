public class CredentialDB {

    private Integer id;
    private String username;
    private String password;

    CredentialDB (Integer id, String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    Integer getID() {return id;}
    String getUsername() {return username;}
    String getPassword() {return password;}

}
