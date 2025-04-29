import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;



public class PasswordManager {
    private ArrayList<Account> accounts;

    public PasswordManager() {
        accounts = new ArrayList<>();
    }

    public Account getAccountByService(String serviceName) {
        for (Account account : accounts) {
            if (account.getServiceName().equalsIgnoreCase(serviceName)) {
                return account;
            }
        }
        return null;
    }


    public void addAccount(String serviceName, String username, String password) {
        accounts.add(new Account(serviceName, username, password));
    }

    public void listAccounts(boolean showPasswords) {
        if (accounts.isEmpty()) System.out.println("No accounts saved");
        else {
            for (Account account : accounts) {
                System.out.println(account.toDisplayString(showPasswords));
            }
        }
    }

    public void deleteAccount(String serviceName){
        Iterator<Account> iterator = accounts.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getServiceName().equals(serviceName)) {
                iterator.remove();
                found = true;
            }
        }

        if (!found) System.out.println("No account found for service: " + serviceName);
    }

    public void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Account account : accounts) {
                writer.write(account.getServiceName() + "|" +
                        account.getUsername() + "|" +
                        account.getPassword() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    addAccount(parts[0], parts[1], parts[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("No saved data found (or error reading file).");
        }
    }
}
