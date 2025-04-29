public class Account {
    private String serviceName;
    private String username;
    private String password;

    public Account(String serviceName, String username, String password) {
        this.serviceName = serviceName;
        this.username = username;
        this.password = password;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Service: " + serviceName
        + "\nUsername: " + username
        + "\nPassword: " + password;
    }

    public String toDisplayString(boolean showPassword) {
        return "Service: " + serviceName +
                "\nUsername: " + username +
                "\nPassword: " + (showPassword ? password : "********");
    }

}
